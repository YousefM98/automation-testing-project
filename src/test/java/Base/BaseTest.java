package Base;

import Utilities.ConfigReader;
import Utilities.MyListener;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Map;

import static java.sql.DriverManager.getDriver;

public class BaseTest {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected WebDriver getDriver() {
        return driver.get();
    }
    public String URL;
    public WebDriverWait wait;
    public SoftAssert SoftAssert;
    protected WebDriver createDriver() {

        String browser = ConfigReader.get("browser");

        return switch (browser.toLowerCase()) {

            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();

                options.setExperimentalOption(
                        "prefs",
                        Map.of(
                                "credentials_enable_service", false,
                                "profile.password_manager_enabled", false
                        )
                );

                options.addArguments("--disable-features=PasswordLeakDetection");
                options.addArguments("--disable-save-password-bubble");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--guest");

                yield new ChromeDriver(options);
            }

            case "firefox" -> new FirefoxDriver();

            case "edge" -> new EdgeDriver();

            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        };
    }
    @BeforeMethod(groups = {"regression", "smoke"})
    public void beforeTC() {

        WebDriver webDriver = createDriver();

        WebDriverListener listener = new MyListener();

        webDriver = new EventFiringDecorator<>(listener)
                .decorate(webDriver);

        driver.set(webDriver);

        getDriver().manage().window().maximize();

        wait = new WebDriverWait(
                getDriver(),
                Duration.ofSeconds(
                        Long.parseLong(
                                ConfigReader.get("explicit.wait")
                        )
                )
        );

        URL = ConfigReader.get("base.url") + ConfigReader.get("LoginExtension");

        getDriver().get(URL);
    }

    @AfterMethod(groups = {"regression", "smoke"})
    public void afterTC(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {

            TakesScreenshot camera =
                    (TakesScreenshot) getDriver();

            File screenshot =
                    camera.getScreenshotAs(OutputType.FILE);

            int generatedNumber =
                    (int) (Math.random() * 1000);

            Files.move(
                    screenshot.toPath(),
                    new File(
                            "target/Screenshots/" +
                                    result.getName() +
                                    generatedNumber +
                                    ".png"
                    ).toPath()
            );
        }

        getDriver().quit();
        driver.remove();
    }
}