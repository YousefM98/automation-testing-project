package Base;

import io.qameta.allure.Allure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;
//allure open allure-report
public class BasePages {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePages(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    protected void attachScreenshot(String name) {

        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment(
                name,
                "image/png",
                new ByteArrayInputStream(screenshot),
                ".png"
        );
    }

}
