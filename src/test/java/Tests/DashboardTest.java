
package Tests;

import Base.BaseTest;
import Base.LoginData;
import Base.TestDataProvider;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(DashboardTest.class);


    @Epic("OrangeHRM Epic")
    @Feature("Covering Dashboard Feature")
    @Description("Validate the OrangeHRM footer link and verify that it opens the official OrangeHRM website in a new tab")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yousef Mohsen")
    @Test(
            groups = "smoke",
            priority = 4,
            description = "Validate OrangeHRM Footer Link",
            dataProvider = "validLoginData",
            dataProviderClass = TestDataProvider.class
    )
    public void verifyOrangeHrmFooterLink(LoginData loginData) {

        logger.info("========== Starting OrangeHRM Footer Link Test ==========");

        // Arrange
        logger.info("Initializing Login Page");
        LoginPage loginPage = new LoginPage(getDriver());

        logger.info("Initializing Dashboard Page");
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        // Act - Login
        logger.info("Logging in with valid credentials for user: {}",
                loginData.getUsername());
        loginPage.login(loginData.getUsername(), loginData.getPassword());

        // Act - Navigate to footer
        logger.info("Scrolling to the footer");
        dashboardPage.scrollToFooter();

        // Assert - Verify footer content
        logger.info("Verifying that the footer contains 'OrangeHRM, Inc'");
        Assert.assertTrue(
                dashboardPage.footerContainsOrangeHrmText(),
                "Footer does not contain 'OrangeHRM, Inc'"
        );
        logger.info("Footer content verification passed");

        // Arrange - Store original window
        logger.info("Storing the original browser window handle");
        String originalWindow = dashboardPage.getOriginalWindow();

        // Act - Open OrangeHRM link
        logger.info("Clicking the OrangeHRM footer link");
        dashboardPage.clickOrangeHrmLink();

        logger.info("Switching to the newly opened OrangeHRM tab");
        dashboardPage.switchToOrangeHrmTab(originalWindow);

        // Assert - Verify new tab URL
        logger.info("Verifying that the new tab URL contains 'orangehrm.com'");
        Assert.assertTrue(
                dashboardPage.isOrangeHrmUrl(),
                "New tab URL does not contain orangehrm.com"
        );
        logger.info("OrangeHRM URL verification passed");

        // Act - Close new tab
        logger.info("Closing the OrangeHRM tab");
        dashboardPage.closeCurrentWindow();

        // Act - Return to original window
        logger.info("Switching back to the original browser window");
        dashboardPage.switchToWindow(originalWindow);

        logger.info("========== OrangeHRM Footer Link Test Passed ==========");
    }


    @Epic("OrangeHRM Epic")
    @Feature("Covering Dashboard Feature")
    @Description("Validate that the Dashboard sidebar menu contains Admin, PIM, Leave, Time, Recruitment, My Info, Performance, Dashboard, and Directory")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yousef Mohsen")
    @Test(
            groups = "smoke",
            priority = 4,
            description = "Validate Dashboard Sidebar Menu",
            dataProvider = "validLoginData",
            dataProviderClass = TestDataProvider.class
    )
    public void verifySidebarMenu(LoginData loginData) {

        logger.info("========== Starting Dashboard Sidebar Menu Test ==========");

        // Arrange
        logger.info("Initializing Login Page");
        LoginPage loginPage = new LoginPage(getDriver());

        logger.info("Initializing Dashboard Page");
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        // Act - Login
        logger.info("Logging in with valid credentials for user: {}",
                loginData.getUsername());
        loginPage.login(loginData.getUsername(), loginData.getPassword());

        // Assert - Admin
        logger.info("Verifying that the Admin menu is displayed");
        Assert.assertTrue(
                dashboardPage.isAdminMenuDisplayed(),
                "Admin menu is not displayed"
        );
        logger.info("Admin menu verification passed");

        // Assert - PIM
        logger.info("Verifying that the PIM menu is displayed");
        Assert.assertTrue(
                dashboardPage.isPimMenuDisplayed(),
                "PIM menu is not displayed"
        );
        logger.info("PIM menu verification passed");

        // Assert - Leave
        logger.info("Verifying that the Leave menu is displayed");
        Assert.assertTrue(
                dashboardPage.isLeaveMenuDisplayed(),
                "Leave menu is not displayed"
        );
        logger.info("Leave menu verification passed");

        // Assert - Time
        logger.info("Verifying that the Time menu is displayed");
        Assert.assertTrue(
                dashboardPage.isTimeMenuDisplayed(),
                "Time menu is not displayed"
        );
        logger.info("Time menu verification passed");

        // Assert - Recruitment
        logger.info("Verifying that the Recruitment menu is displayed");
        Assert.assertTrue(
                dashboardPage.isRecruitmentMenuDisplayed(),
                "Recruitment menu is not displayed"
        );
        logger.info("Recruitment menu verification passed");

        // Assert - My Info
        logger.info("Verifying that the My Info menu is displayed");
        Assert.assertTrue(
                dashboardPage.isMyInfoMenuDisplayed(),
                "My Info menu is not displayed"
        );
        logger.info("My Info menu verification passed");

        // Assert - Performance
        logger.info("Verifying that the Performance menu is displayed");
        Assert.assertTrue(
                dashboardPage.isPerformanceMenuDisplayed(),
                "Performance menu is not displayed"
        );
        logger.info("Performance menu verification passed");

        // Assert - Dashboard
        logger.info("Verifying that the Dashboard menu is displayed");
        Assert.assertTrue(
                dashboardPage.isDashboardMenuDisplayed(),
                "Dashboard menu is not displayed"
        );
        logger.info("Dashboard menu verification passed");

        // Assert - Directory
        logger.info("Verifying that the Directory menu is displayed");
        Assert.assertTrue(
                dashboardPage.isDirectoryMenuDisplayed(),
                "Directory menu is not displayed"
        );
        logger.info("Directory menu verification passed");

        logger.info("========== Dashboard Sidebar Menu Test Passed ==========");
    }
}

