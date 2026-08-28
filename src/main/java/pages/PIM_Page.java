package pages;
import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class PIM_Page extends BasePages {

    // -------------------- Navigation Locators --------------------

    // PIM menu item in the main sidebar
    private By pimLocator = By.xpath(
            "//li[2]/a/span"
    );


    // -------------------- Employee Search Locators --------------------

    // Employee Name input field used to search for employees
    private By employeeNameInputFieldLocator = By.xpath(
            "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input"
    );

    // Add button used to open the Add Employee page
    private By addButtonLocator = By.xpath(
            "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[1]/button"
    );

    // Search button used to submit the employee search
    private By searchButtonLocator = By.xpath(
            "//button[@type='submit']"
    );

    // Reset button used to clear the employee search form
    private By resetButtonLocator = By.xpath(
            "//button[@type='reset']"
    );


    // -------------------- Employee Results Locators --------------------

    // First Name cell of the first employee displayed in the search results
    private By firstNameResultLocator = By.xpath(
            "(//div[@role='row'])[2]//div[@role='cell'][3]"
    );

    // Last Name cell of the first employee displayed in the search results
    private By lastNameResultLocator = By.xpath(
            "(//div[@role='row'])[2]//div[@role='cell'][4]"
    );


    // -------------------- Add Employee Form Locators --------------------

    // First Name input field on the Add Employee form
    private By firstNameInputFieldLocator = By.xpath(
            "//input[@name='firstName']"
    );

    // Last Name input field on the Add Employee form
    private By lastNameInputFieldLocator = By.xpath(
            "//input[@name='lastName']"
    );

    // Save button used to submit the Add Employee form
    private By saveButtonLocator = By.xpath(
            "//button[@type='submit']"
    );


    // -------------------- Validation Message Locators --------------------

    // Message displayed when no employees match the search criteria
    private By noRecordsMessageLocator = By.xpath(
            "//span[text()='No Records Found']"
    );

    // Required validation message for the First Name field
    private By requiredFirstNameMessageLocator = By.xpath(
            "//input[@name='firstName']/../following-sibling::span"
    );

    // Required validation message for the Last Name field
    private By requiredLastNameMessageLocator = By.xpath(
            "//input[@name='lastName']/../following-sibling::span"
    );


    // -------------------- Constructor --------------------

    public PIM_Page(WebDriver driver) {
        super(driver);
    }


    // -------------------- Element Getters --------------------
    // These methods wait for the required elements before returning them.
    // Keeping the explicit waits inside the Page Object helps prevent
    // synchronization logic from being duplicated in the test classes.

    // Returns the PIM menu item once it becomes clickable
    private WebElement getPimElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(pimLocator)
        );
    }

    // Returns the Employee Name search field once it becomes visible
    private WebElement getEmployeeNameInputFieldElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        employeeNameInputFieldLocator
                )
        );
    }

    // Returns the Add button once it becomes clickable
    private WebElement getAddButtonElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(addButtonLocator)
        );
    }

    // Returns the Search button once it becomes clickable
    private WebElement getSearchButtonElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(searchButtonLocator)
        );
    }

    // Returns the Reset button once it becomes clickable
    private WebElement getResetButtonElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(resetButtonLocator)
        );
    }

    // Returns the First Name cell from the first search result once visible
    private WebElement getFirstNameResultElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        firstNameResultLocator
                )
        );
    }

    // Returns the Last Name cell from the first search result once visible
    private WebElement getLastNameResultElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        lastNameResultLocator
                )
        );
    }

    // Returns the First Name input field once it becomes visible
    private WebElement getFirstNameInputFieldElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        firstNameInputFieldLocator
                )
        );
    }

    // Returns the Last Name input field once it becomes visible
    private WebElement getLastNameInputFieldElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        lastNameInputFieldLocator
                )
        );
    }

    // Returns the Save button once it becomes clickable
    private WebElement getSaveButtonElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(
                        saveButtonLocator
                )
        );
    }

    // Returns the No Records Found message once it becomes visible
    private WebElement getNoRecordsMessageElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        noRecordsMessageLocator
                )
        );
    }

    // Returns the required validation message for the First Name field
    private WebElement getRequiredFirstNameMessageElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        requiredFirstNameMessageLocator
                )
        );
    }

    // Returns the required validation message for the Last Name field
    private WebElement getRequiredLastNameMessageElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        requiredLastNameMessageLocator
                )
        );
    }




// -------------------- Navigation Actions --------------------

// Opens the PIM section from the main sidebar
    @Step("Click PIM menu")
    public void clickPIM() {
        getPimElement().click();
        attachScreenshot("Click PIM menu");
    }

    // Opens the Add Employee page
    @Step("Click Add Employee button")
    public void clickAddButton() {
        getAddButtonElement().click();
        attachScreenshot("Click Add Employee button");
    }


// -------------------- Search Actions --------------------

    // Submits the employee search form
    @Step("Click Search button")
    public void clickSearchButton() {
        getSearchButtonElement().click();
        attachScreenshot("Click Search button");
    }

    // Resets the employee search form
    @Step("Click Reset button")
    public void clickResetButton() {
        getResetButtonElement().click();
        attachScreenshot("Click Reset button");
    }


// -------------------- Employee Form Actions --------------------

    // Enters an employee's full name into the Employee Name search field
    @Step("Enter employee name in the Employee Name field")
    public void enterEmployeeName(String employeeName) {
        getEmployeeNameInputFieldElement().sendKeys(employeeName);
        attachScreenshot("Enter employee name in the Employee Name field");
    }

    // Enters the employee's first name
    @Step("Enter first name in the First Name field")
    public void enterFirstName(String firstName) {
        getFirstNameInputFieldElement().sendKeys(firstName);
        attachScreenshot("Enter first name in the First Name field");
    }

    // Enters the employee's last name
    @Step("Enter last name in the Last Name field")
    public void enterLastName(String lastName) {
        getLastNameInputFieldElement().sendKeys(lastName);
        attachScreenshot("Enter last name in the Last Name field");
    }

    // Saves the Add Employee form
    @Step("Click Save button")
    public void clickSaveButton() {
        getSaveButtonElement().click();
        attachScreenshot("Click Save button");
    }





    // -------------------- Search Result Validations --------------------

    // Verifies that the expected employee name is displayed in the search results
    public boolean isNameDisplayedInResults(String expectedName) {

        String firstName = getFirstNameResultElement().getText();
        String lastName = getLastNameResultElement().getText();

        String actualName = firstName + " " + lastName;

        return actualName.equals(expectedName);
    }

    // Verifies that the No Records Found message is displayed
    public boolean isNoRecordsMessageDisplayed() {
        return getNoRecordsMessageElement()
                .getText()
                .trim()
                .equals("No Records Found");
    }


    // -------------------- Form Validation --------------------

    // Verifies that the Required message is displayed for the First Name field
    public boolean isRequiredFirstNameMessageDisplayed() {
        return getRequiredFirstNameMessageElement()
                .getText()
                .trim()
                .equals("Required");
    }

    // Verifies that the Required message is displayed for the Last Name field
    public boolean isRequiredLastNameMessageDisplayed() {
        return getRequiredLastNameMessageElement()
                .getText()
                .trim()
                .equals("Required");
    }


    // -------------------- Form Field Validations --------------------

    // Verifies that the First Name input field is displayed
    public boolean isFirstNameInputFieldDisplayed() {
        return getFirstNameInputFieldElement()
                .isDisplayed();
    }

    // Verifies that the Last Name input field is displayed
    public boolean isLastNameInputFieldDisplayed() {
        return getLastNameInputFieldElement()
                .isDisplayed();
    }


    // -------------------- Page Information --------------------

    // Returns the current browser URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

