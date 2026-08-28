
package Tests;

import Base.BaseTest;
import Base.LoginData;
import Base.TestDataProvider;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;

public class AdminTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(AdminTest.class);


    @Epic("OrangeHRM Epic")
    @Feature("Covering Admin Feature")
    @Description("Validate that the Add User page contains User Role, Employee Name, Username, and Password fields")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yousef Mohsen")
    @Test(
            groups = "smoke",
            priority = 3,
            description = "Validate Add User Page Content",
            dataProvider = "validLoginData",
            dataProviderClass = TestDataProvider.class
    )
    public void validateAddUserContent(LoginData loginData) {

        logger.info("========== Starting Add User Content Test ==========");

        // Arrange
        logger.info("Initializing Login Page");
        LoginPage loginPage = new LoginPage(getDriver());

        logger.info("Initializing Admin Page");
        AdminPage adminPage = new AdminPage(getDriver());

        // Act - Login
        logger.info("Logging in with valid credentials for user: {}",
                loginData.getUsername());
        loginPage.login(loginData.getUsername(), loginData.getPassword());

        // Act - Navigate to Users page
        logger.info("Navigating to Admin page");
        adminPage.clickAdmin();

        logger.info("Opening User Management menu");
        adminPage.clickUserManagement();

        logger.info("Opening Users page");
        adminPage.clickUsers();

        // Act - Navigate to Add User page
        logger.info("Clicking Add button to open Add User page");
        adminPage.clickAdd();

        // Assert - User Role
        logger.info("Verifying that the User Role dropdown is displayed");
        Assert.assertTrue(
                adminPage.isUserRoleDisplayed(),
                "User Role dropdown is not displayed"
        );
        logger.info("User Role dropdown verification passed");

        // Assert - Employee Name
        logger.info("Verifying that the Employee Name field is displayed");
        Assert.assertTrue(
                adminPage.isEmployeeNameDisplayed(),
                "Employee Name field is not displayed"
        );
        logger.info("Employee Name field verification passed");

        // Assert - Username
        logger.info("Verifying that the Username field is displayed");
        Assert.assertTrue(
                adminPage.isUsernameDisplayed(),
                "Username field is not displayed"
        );
        logger.info("Username field verification passed");

        // Assert - Password
        logger.info("Verifying that the Password field is displayed");
        Assert.assertTrue(
                adminPage.isPasswordDisplayed(),
                "Password field is not displayed"
        );
        logger.info("Password field verification passed");

        logger.info("========== Add User Content Test Passed ==========");
    }
}

