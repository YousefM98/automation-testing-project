package pages;
import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class AdminPage extends BasePages {

    // -------------------- Navigation Locators --------------------

    // Admin item in the main sidebar menu
    private By adminLocator = By.xpath("//span[text()='Admin']");

    // User Management menu in the Admin top navigation
    private By userManagementLocator = By.xpath(
            "//nav[contains(@aria-label, 'Topbar')]/ul/li"
    );

    // Users option under User Management
    private By usersLocator = By.xpath("//a[text()='Users']");


    // -------------------- Add User Form Locators --------------------

    // Username input field on the Add User form
    private By userNameInputFieldLocator = By.xpath(
            "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input"
    );

    // User Role dropdown on the Add User form
    private By userRoleDropDownLocator = By.xpath(
            "//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]"
    );

    // Employee Name input field on the Add User form
    private By employeeNameInputFieldLocator = By.xpath(
            "//input[@placeholder='Type for hints...']"
    );

    // Add button used to open the Add User form
    private By addButtonLocator = By.xpath(
            "//button[normalize-space()='Add']"
    );

    // Password input field on the Add User form
    // This locator assumes the current OrangeHRM version uses a password input
    private By passwordInputFieldLocator = By.xpath(
            "//input[@type='password']"
    );


    // -------------------- Constructor --------------------

    public AdminPage(WebDriver driver) {
        super(driver);
    }


    // -------------------- Element Getters --------------------
    // These methods wait for the required element before returning it.
    // Keeping waits inside the Page Object prevents synchronization logic
    // from being repeated in the test classes.

    // Returns the Admin sidebar element once it is clickable
    private WebElement getAdminElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(adminLocator)
        );
    }

    // Returns the User Management menu once it is clickable
    private WebElement getUserManagementElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(userManagementLocator)
        );
    }

    // Returns the Users menu item once it is clickable
    private WebElement getUsersElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(usersLocator)
        );
    }

    // Returns the Add button once it is clickable
    private WebElement getAddButtonElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(addButtonLocator)
        );
    }

    // Returns the Username input field once it is visible
    private WebElement getUserNameInputFieldElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        userNameInputFieldLocator
                )
        );
    }

    // Returns the User Role dropdown once it is visible
    private WebElement getUserRoleDropDownElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        userRoleDropDownLocator
                )
        );
    }

    // Returns the Employee Name input field once it is visible
    private WebElement getEmployeeNameInputFieldElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        employeeNameInputFieldLocator
                )
        );
    }

    // Returns the Password input field once it is visible
    private WebElement getPasswordInputFieldElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        passwordInputFieldLocator
                )
        );
    }


    // -------------------- Actions --------------------

    // Opens the Admin section from the main sidebar
    @Step("Click Admin menu")
    public void clickAdmin() {
        getAdminElement().click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        addButtonLocator
                )
        );
        attachScreenshot("Click Admin menu");
    }


    // Opens the User Management menu
    @Step("Click User Management menu")
    public void clickUserManagement() {
        getUserManagementElement().click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        addButtonLocator
                )
        );
        attachScreenshot("Click User Management menu");
    }


    // Opens the Users page
    @Step("Click Users menu")
    public void clickUsers() {
        getUsersElement().click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        addButtonLocator
                )
        );
        attachScreenshot("Click Users menu");
    }


    // Opens the Add User form
    @Step("Click Add User button")
    public void clickAdd() {
        getAddButtonElement().click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        userNameInputFieldLocator
                )
        );
        attachScreenshot("Click Add User button");
    }


    // -------------------- Validations --------------------

    // Verifies that the User Role dropdown is displayed
    public boolean isUserRoleDisplayed() {
        return getUserRoleDropDownElement().isDisplayed();
    }

    // Verifies that the Employee Name input field is displayed
    public boolean isEmployeeNameDisplayed() {
        return getEmployeeNameInputFieldElement().isDisplayed();
    }

    // Verifies that the Username input field is displayed
    public boolean isUsernameDisplayed() {
        return getUserNameInputFieldElement().isDisplayed();
    }

    // Verifies that the Password input field is displayed
    public boolean isPasswordDisplayed() {
        return getPasswordInputFieldElement().isDisplayed();
    }
}

