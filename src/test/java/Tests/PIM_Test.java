
package Tests;

import Base.BaseTest;
import Base.LoginData;
import Base.SearchData;
import Base.TestDataProvider;
import Utilities.ConfigReader;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIM_Page;

public class PIM_Test extends BaseTest {

    private static final Logger logger =
            LogManager.getLogger(PIM_Test.class);


    @Epic("OrangeHRM Epic")
    @Feature("Covering PIM Feature")
    @Description("Validate successful search for an existing employee by name")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yousef Mohsen")
    @Test(
            groups = "smoke",
            priority = 2,
            description = "Validate Successful Search for Employee by Name",
            dataProvider = "existingEmployeeData",
            dataProviderClass = TestDataProvider.class
    )
    public void validateSearchForExistingEmployee(
            LoginData loginData,
            SearchData searchData) {

        logger.info("========== Starting Existing Employee Search Test ==========");

        // Arrange
        logger.info("Initializing Login Page");
        LoginPage loginPage = new LoginPage(getDriver());

        logger.info("Initializing PIM Page");
        PIM_Page pimPage = new PIM_Page(getDriver());

        // Act - Login
        logger.info("Logging in with valid credentials for user: {}",
                loginData.getUsername());
        loginPage.login(loginData.getUsername(), loginData.getPassword());

        // Act - Navigate to PIM
        logger.info("Navigating to PIM page");
        pimPage.clickPIM();

        // Act - Search for existing employee
        logger.info("Searching for existing employee: {}", searchData.getFullName());
        pimPage.enterEmployeeName(searchData.getFullName());

        logger.info("Clicking Search button");
        pimPage.clickSearchButton();

        // Assert
        logger.info("Verifying that the searched employee is displayed in the results");
        Assert.assertTrue(
                pimPage.isNameDisplayedInResults(searchData.getFullName()),
                "Searched employee name is not displayed in results"
        );
        logger.info("Existing employee search verification passed");

        logger.info("========== Existing Employee Search Test Passed ==========");
    }


    @Epic("OrangeHRM Epic")
    @Feature("Covering PIM Feature")
    @Description("Validate failed search for a non-existing employee by name")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yousef Mohsen")
    @Test(
            groups = "smoke",
            priority = 2,
            description = "Validate Failed Search for Non-Existing Employee by Name",
            dataProvider = "invalidSearchData",
            dataProviderClass = TestDataProvider.class
    )
    public void validateSearchForNonExistingEmployee(
            LoginData loginData,
            SearchData searchData) {

        logger.info("========== Starting Non-Existing Employee Search Test ==========");

        // Arrange
        logger.info("Initializing Login Page");
        LoginPage loginPage = new LoginPage(getDriver());

        logger.info("Initializing PIM Page");
        PIM_Page pimPage = new PIM_Page(getDriver());

        String employeeName =
                searchData.getFirstName() + " " + searchData.getLastName();

        // Act - Login
        logger.info("Logging in with valid credentials for user: {}",
                loginData.getUsername());
        loginPage.login(loginData.getUsername(), loginData.getPassword());

        // Act - Navigate to PIM
        logger.info("Navigating to PIM page");
        pimPage.clickPIM();

        // Act - Search for non-existing employee
        logger.info("Searching for non-existing employee: {}", employeeName);
        pimPage.enterEmployeeName(employeeName);

        logger.info("Clicking Search button");
        pimPage.clickSearchButton();

        // Assert
        logger.info("Verifying that the 'No Records Found' message is displayed");
        Assert.assertTrue(
                pimPage.isNoRecordsMessageDisplayed(),
                "No records found message is not displayed"
        );
        logger.info("No Records Found message verification passed");

        logger.info("========== Non-Existing Employee Search Test Passed ==========");
    }


    @Epic("OrangeHRM Epic")
    @Feature("Covering PIM Feature")
    @Description("Validate Add Employee page URL and verify first name and last name input fields")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yousef Mohsen")
    @Test(
            groups = "smoke",
            priority = 2,
            description = "Validate Add Employee Page",
            dataProvider = "validSearchData",
            dataProviderClass = TestDataProvider.class
    )
    public void validateAddEmployeePage(
            LoginData loginData,
            SearchData searchData) {

        logger.info("========== Starting Add Employee Page Test ==========");

        // Arrange
        logger.info("Initializing Login Page");
        LoginPage loginPage = new LoginPage(getDriver());

        logger.info("Initializing PIM Page");
        PIM_Page pimPage = new PIM_Page(getDriver());

        // Act - Login
        logger.info("Logging in with valid credentials for user: {}",
                loginData.getUsername());
        loginPage.login(loginData.getUsername(), loginData.getPassword());

        // Act - Navigate to Add Employee page
        logger.info("Navigating to PIM page");
        pimPage.clickPIM();

        logger.info("Clicking Add Employee button");
        pimPage.clickAddButton();

        // Assert - Verify first name field
        logger.info("Verifying that the First Name input field is displayed");
        Assert.assertTrue(
                pimPage.isFirstNameInputFieldDisplayed(),
                "First name input field should be displayed"
        );
        logger.info("First Name input field verification passed");

        // Assert - Verify last name field
        logger.info("Verifying that the Last Name input field is displayed");
        Assert.assertTrue(
                pimPage.isLastNameInputFieldDisplayed(),
                "Last name input field should be displayed"
        );
        logger.info("Last Name input field verification passed");

        // Assert - Verify URL
        logger.info("Verifying that the current URL contains the Add Employee URL extension");
        Assert.assertTrue(
                pimPage.getCurrentUrl().contains(
                        ConfigReader.get("AddEmployeeExtension")
                ),
                "Current URL is not the add employee page URL"
        );
        logger.info("Add Employee URL verification passed");

        logger.info("========== Add Employee Page Test Passed ==========");
    }


    @Epic("OrangeHRM Epic")
    @Feature("Covering PIM Feature")
    @Description("Validate that an employee cannot be added with an empty first name field")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yousef Mohsen")
    @Test(
            groups = "smoke",
            priority = 2,
            description = "Validate Add Employee with Empty First Name",
            dataProvider = "validSearchData",
            dataProviderClass = TestDataProvider.class
    )
    public void validateAddEmployeeWithEmptyField(
            LoginData loginData,
            SearchData searchData) {

        logger.info("========== Starting Add Employee Empty First Name Test ==========");

        // Arrange
        logger.info("Initializing Login Page");
        LoginPage loginPage = new LoginPage(getDriver());

        logger.info("Initializing PIM Page");
        PIM_Page pimPage = new PIM_Page(getDriver());

        // Act - Login
        logger.info("Logging in with valid credentials for user: {}",
                loginData.getUsername());
        loginPage.login(loginData.getUsername(), loginData.getPassword());

        // Act - Navigate to Add Employee page
        logger.info("Navigating to PIM page");
        pimPage.clickPIM();

        logger.info("Clicking Add Employee button");
        pimPage.clickAddButton();

        // Act - Enter only last name
        logger.info("Entering last name: {}", searchData.getLastName());
        pimPage.enterLastName(searchData.getLastName());

        logger.info("Clicking Save button without entering first name");
        pimPage.clickSaveButton();

        // Assert
        logger.info("Verifying that the required message is displayed under the First Name field");
        Assert.assertTrue(
                pimPage.isRequiredFirstNameMessageDisplayed(),
                "Required message is not displayed under first name input field"
        );
        logger.info("First Name required message verification passed");

        logger.info("========== Add Employee Empty First Name Test Passed ==========");
    }


    @Epic("OrangeHRM Epic")
    @Feature("Covering PIM Feature")
    @Description("Validate successful end-to-end functionality by adding a new employee and searching for the employee in the list")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yousef Mohsen")
    @Test(
            groups = "smoke",
            priority = 2,
            description = "Validate Successful End-to-End Employee Creation and Search",
            dataProvider = "validSearchData",
            dataProviderClass = TestDataProvider.class
    )
    public void validateEndtoEndFunctionality(
            LoginData loginData,
            SearchData searchData) {

        logger.info("========== Starting End-to-End Employee Test ==========");

        // Arrange
        logger.info("Initializing Login Page");
        LoginPage loginPage = new LoginPage(getDriver());

        logger.info("Initializing PIM Page");
        PIM_Page pimPage = new PIM_Page(getDriver());

        String employeeName =
                searchData.getFirstName() + " " + searchData.getLastName();

        // Act - Login
        logger.info("Logging in with valid credentials for user: {}",
                loginData.getUsername());
        loginPage.login(loginData.getUsername(), loginData.getPassword());

        // Act - Navigate to PIM
        logger.info("Navigating to PIM page");
        pimPage.clickPIM();

        // Act - Add Employee
        logger.info("Clicking Add Employee button");
        pimPage.clickAddButton();

        logger.info("Entering first name: {}", searchData.getFirstName());
        pimPage.enterFirstName(searchData.getFirstName());

        logger.info("Entering last name: {}", searchData.getLastName());
        pimPage.enterLastName(searchData.getLastName());

        logger.info("Saving new employee: {}", employeeName);
        pimPage.clickSaveButton();

        // Act - Navigate back to PIM employee list
        logger.info("Navigating back to PIM employee list");
        pimPage.clickPIM();

        // Act - Search for newly created employee
        logger.info("Searching for newly created employee: {}", employeeName);
        pimPage.enterEmployeeName(employeeName);

        logger.info("Clicking Search button");
        pimPage.clickSearchButton();

        // Assert
        logger.info("Verifying that the newly created employee is displayed in the search results");
        Assert.assertTrue(
                pimPage.isNameDisplayedInResults(employeeName),
                "Searched employee name is not displayed in results"
        );
        logger.info("Newly created employee search verification passed");

        logger.info("========== End-to-End Employee Test Passed ==========");
    }
}

