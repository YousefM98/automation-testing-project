package pages;
import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePages {

    // -------------------- Login Page Locators --------------------

    // Username input field
    private By usernameFieldLocator = By.xpath(
            "//input[@name='username']"
    );

    // Password input field
    private By passwordFieldLocator = By.name("password");

    // Login button
    private By loginButtonLocator = By.xpath(
            "//button[@type='submit']"
    );

    // Error message displayed when invalid credentials are submitted
    private By errorMessageLocator = By.xpath(
            "//*[text()='Invalid credentials']"
    );

    // Dashboard header displayed after successful login
    private By dashboardHeaderLocator = By.xpath(
            "//h6[text()='Dashboard']"
    );

    // Required validation message for the username field
    private By userNameRequiredMessageLocator = By.xpath(
            "//form/div[1]/div/span"
    );

    // Required validation message for the password field
    private By passwordRequiredMessageLocator = By.xpath(
            "//form/div[2]/div/span"
    );


    // -------------------- Constructor --------------------

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    // -------------------- Login Page Elements --------------------
    // These methods wait for the required elements before returning them.
    // This keeps synchronization logic inside the Page Object.

    // Returns the username field once it becomes visible
    private WebElement getUsernameFieldElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        usernameFieldLocator
                )
        );
    }

    // Returns the password field once it becomes visible
    private WebElement getPasswordFieldElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        passwordFieldLocator
                )
        );
    }

    // Returns the Login button once it becomes clickable
    private WebElement getLoginButtonElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginButtonLocator
                )
        );
    }

    // Returns the invalid credentials error message once it becomes visible
    private WebElement getErrorMessageElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        errorMessageLocator
                )
        );
    }

    // Returns the Dashboard header once it becomes visible
    private WebElement getDashboardHeaderElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        dashboardHeaderLocator
                )
        );
    }

    // Returns the username required validation message once it becomes visible
    private WebElement getUserNameRequiredMessageElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        userNameRequiredMessageLocator
                )
        );
    }

    // Returns the password required validation message once it becomes visible
    private WebElement getPasswordRequiredMessageElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        passwordRequiredMessageLocator
                )
        );
    }


    // -------------------- Actions --------------------


// Enters the provided username into the username field
    @Step("Enter username in the username field")
    public void enterUsername(String username) {
        getUsernameFieldElement().sendKeys(username);
        attachScreenshot("Enter username in the username field");
    }


    // Enters the provided password into the password field
    @Step("Enter password in the password field")
    public void enterPassword(String password) {
        getPasswordFieldElement().sendKeys(password);
        attachScreenshot("Enter password in the password field");
    }


    // Clicks the Login button
// The element getter already waits until the button is clickable.
    @Step("Click Login button")
    public void clickLoginButton() {
        getLoginButtonElement().click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Login wait was interrupted", e);
        }
        attachScreenshot("Click Login button");
    }


    // Performs the complete login flow using the provided credentials
    @Step("Login with provided credentials")
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Login wait was interrupted", e);
        }
        attachScreenshot("Login with provided credentials");
    }




    // -------------------- Validations / Getters --------------------

    // Returns the invalid credentials error message text
    public String getErrorMessage() {
        return getErrorMessageElement().getText();
    }

    // Returns the Dashboard header text after successful login
    public String getDashboardHeader() {
        return getDashboardHeaderElement().getText();
    }

    // Returns the required validation message displayed under the username field
    public String getUsernameRequiredMessage() {
        return getUserNameRequiredMessageElement().getText();
    }

    // Returns the required validation message displayed under the password field
    public String getPasswordRequiredMessage() {
        return getPasswordRequiredMessageElement().getText();
    }

    // Returns the current browser URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}


