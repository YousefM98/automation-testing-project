
package Tests;

import Base.BaseTest;
import Base.LoginData;
import Base.TestDataProvider;
import Utilities.ConfigReader;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(LoginTest.class);

    @Epic("OrangeHRM Epic")
    @Feature("Covering Login Feature")
    @Description("Validate successful login using valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yousef Mohsen")
    @Test(
            groups = "smoke",
            priority = 1,
            description = "Validate Successful Login",
            dataProvider = "validLoginData",
            dataProviderClass = TestDataProvider.class
    )
    public void validateSuccessfulLogin(LoginData loginData) {

        logger.info("========== Starting Successful Login Test ==========");

        // Arrange
        logger.info("Initializing Login Page");
        LoginPage loginPage = new LoginPage(getDriver());

        // Act
        logger.info("Attempting login with valid credentials for user: {}",
                loginData.getUsername());
        loginPage.login(loginData.getUsername(), loginData.getPassword());

        // Assert - Verify successful navigation to Dashboard
        logger.info("Verifying that the current URL contains the Dashboard URL extension");
        Assert.assertTrue(
                loginPage.getCurrentUrl().contains(ConfigReader.get("DashboardExtension")),
                "Current URL is not dashboard page URL"
        );
        logger.info("Dashboard URL verification passed");

        // Assert - Verify Dashboard header
        logger.info("Verifying that the Dashboard header is displayed");
        Assert.assertEquals(
                loginPage.getDashboardHeader(),
                "Dashboard",
                "Dashboard header is not displayed correctly"
        );
        logger.info("Dashboard header verification passed");

        logger.info("========== Successful Login Test Passed ==========");
    }


    @Epic("OrangeHRM Epic")
    @Feature("Covering Login Feature")
    @Description("Validate failed login using invalid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yousef Mohsen")
    @Test(
            groups = "smoke",
            priority = 1,
            description = "Validate Failed Login with Invalid Credentials",
            dataProvider = "invalidLoginData",
            dataProviderClass = TestDataProvider.class
    )
    public void validateFailedLoginInvalidCredentials(LoginData loginData) {

        logger.info("========== Starting Invalid Credentials Login Test ==========");

        // Arrange
        logger.info("Initializing Login Page");
        LoginPage loginPage = new LoginPage(getDriver());

        // Act
        logger.info("Attempting login with invalid credentials for user: {}",
                loginData.getUsername());
        loginPage.login(loginData.getUsername(), loginData.getPassword());

        // Assert - Verify user remains on Login page
        logger.info("Verifying that the current URL contains the Login URL extension");
        Assert.assertTrue(
                loginPage.getCurrentUrl().contains(ConfigReader.get("LoginExtension")),
                "Current URL is not login page URL"
        );
        logger.info("Login URL verification passed");

        // Assert - Verify invalid credentials error message
        logger.info("Verifying that the invalid credentials error message is displayed");
        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Invalid credentials",
                "Invalid credentials error message is not displayed correctly"
        );
        logger.info("Invalid credentials error message verification passed");

        logger.info("========== Invalid Credentials Login Test Passed ==========");
    }


    @Epic("OrangeHRM Epic")
    @Feature("Covering Login Feature")
    @Description("Validate failed login when username and password fields are empty")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yousef Mohsen")
    @Test(
            groups = "smoke",
            priority = 1,
            description = "Validate Failed Login with Empty Fields"
    )
    public void validateFailedLoginEmptyFields() {

        logger.info("========== Starting Empty Fields Login Test ==========");

        // Arrange
        logger.info("Initializing Login Page");
        LoginPage loginPage = new LoginPage(getDriver());

        // Act
        logger.info("Attempting login with empty username and password fields");
        loginPage.login("", "");

        // Assert - Verify user remains on Login page
        logger.info("Verifying that the current URL contains the Login URL extension");
        Assert.assertTrue(
                loginPage.getCurrentUrl().contains(ConfigReader.get("LoginExtension")),
                "Current URL is not login page URL"
        );
        logger.info("Login URL verification passed");

        // Assert - Verify username required message
        logger.info("Verifying username required validation message");
        Assert.assertEquals(
                loginPage.getUsernameRequiredMessage(),
                "Required",
                "Username required validation message is incorrect"
        );
        logger.info("Username required validation message verification passed");

        // Assert - Verify password required message
        logger.info("Verifying password required validation message");
        Assert.assertEquals(
                loginPage.getPasswordRequiredMessage(),
                "Required",
                "Password required validation message is incorrect"
        );
        logger.info("Password required validation message verification passed");

        logger.info("========== Empty Fields Login Test Passed ==========");
    }
}