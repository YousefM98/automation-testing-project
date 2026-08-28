package pages;
import Base.BasePages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class DashboardPage extends BasePages {

    // -------------------- Footer Locators --------------------

    // Main footer container at the bottom of the Dashboard page
    private By footerTextLocator = By.xpath(
            "//div[@class='oxd-layout-footer']"
    );

    // OrangeHRM link displayed inside the footer
    private By orangeHrmLinkLocator = By.xpath(
            "//div[@class='oxd-layout-footer']//a[contains(normalize-space(), 'OrangeHRM, Inc')]"
    );


    // -------------------- Sidebar Locators --------------------

    // Admin menu item in the Dashboard sidebar
    private By adminMenuLocator = By.xpath(
            "//span[normalize-space()='Admin']"
    );

    // PIM menu item in the Dashboard sidebar
    private By pimMenuLocator = By.xpath(
            "//span[normalize-space()='PIM']"
    );

    // Leave menu item in the Dashboard sidebar
    private By leaveMenuLocator = By.xpath(
            "//span[normalize-space()='Leave']"
    );

    // Time menu item in the Dashboard sidebar
    private By timeMenuLocator = By.xpath(
            "//span[normalize-space()='Time']"
    );

    // Recruitment menu item in the Dashboard sidebar
    private By recruitmentMenuLocator = By.xpath(
            "//span[normalize-space()='Recruitment']"
    );

    // My Info menu item in the Dashboard sidebar
    private By myInfoMenuLocator = By.xpath(
            "//span[normalize-space()='My Info']"
    );

    // Performance menu item in the Dashboard sidebar
    private By performanceMenuLocator = By.xpath(
            "//span[normalize-space()='Performance']"
    );

    // Dashboard menu item in the Dashboard sidebar
    private By dashboardMenuLocator = By.xpath(
            "//span[normalize-space()='Dashboard']"
    );

    // Directory menu item in the Dashboard sidebar
    private By directoryMenuLocator = By.xpath(
            "//span[normalize-space()='Directory']"
    );


    // -------------------- Constructor --------------------

    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    // -------------------- Footer Elements --------------------
    // These methods wait for the footer elements before returning them.

    // Returns the footer once it becomes visible
    private WebElement getFooterElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(footerTextLocator)
        );
    }

    // Returns the OrangeHRM footer link once it becomes clickable
    private WebElement getOrangeHrmLinkElement() {
        return wait.until(
                ExpectedConditions.elementToBeClickable(orangeHrmLinkLocator)
        );
    }


    // -------------------- Sidebar Elements --------------------
    // These methods wait for the corresponding sidebar menu items
    // before returning them.

    // Returns the Admin menu item once it becomes visible
    private WebElement getAdminMenuElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(adminMenuLocator)
        );
    }

    // Returns the PIM menu item once it becomes visible
    private WebElement getPimMenuElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(pimMenuLocator)
        );
    }

    // Returns the Leave menu item once it becomes visible
    private WebElement getLeaveMenuElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(leaveMenuLocator)
        );
    }

    // Returns the Time menu item once it becomes visible
    private WebElement getTimeMenuElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(timeMenuLocator)
        );
    }

    // Returns the Recruitment menu item once it becomes visible
    private WebElement getRecruitmentMenuElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(recruitmentMenuLocator)
        );
    }

    // Returns the My Info menu item once it becomes visible
    private WebElement getMyInfoMenuElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(myInfoMenuLocator)
        );
    }

    // Returns the Performance menu item once it becomes visible
    private WebElement getPerformanceMenuElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(performanceMenuLocator)
        );
    }

    // Returns the Dashboard menu item once it becomes visible
    private WebElement getDashboardMenuElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(dashboardMenuLocator)
        );
    }

    // Returns the Directory menu item once it becomes visible
    private WebElement getDirectoryMenuElement() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(directoryMenuLocator)
        );
    }


    // -------------------- Footer and Navigation Actions --------------------


// Scrolls the page until the footer is positioned near the center of the viewport
    @Step("Scroll to footer")
    public void scrollToFooter() {
        WebElement footer = getFooterElement();

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                footer
        );
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        footerTextLocator
                )
        );
        attachScreenshot("Scroll to footer");
    }


    // Clicks the OrangeHRM link in the footer
    @Step("Click OrangeHRM footer link")
    public void clickOrangeHrmLink() {
        getOrangeHrmLinkElement().click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        footerTextLocator
                )
        );
        attachScreenshot("Click OrangeHRM footer link");
    }




    // -------------------- Window Handling --------------------

    // Waits for the new tab to open and switches to the newly opened window
    public void switchToOrangeHrmTab(String originalWindow) {

        wait.until(
                ExpectedConditions.numberOfWindowsToBe(2)
        );

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    // Returns the handle of the currently active browser window
    public String getOriginalWindow() {
        return driver.getWindowHandle();
    }

    // Verifies that the current browser URL belongs to OrangeHRM
    public boolean isOrangeHrmUrl() {
        return driver.getCurrentUrl().contains("orangehrm.com");
    }

    // Closes the currently active browser window
    public void closeCurrentWindow() {
        driver.close();
    }

    // Switches the browser to the specified window
    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }


    // -------------------- Footer Validations --------------------

    // Verifies that the footer contains the expected OrangeHRM company text
    public boolean footerContainsOrangeHrmText() {
        return getFooterElement()
                .getText()
                .contains("OrangeHRM, Inc");
    }


    // -------------------- Sidebar Validations --------------------

    // Verifies that the Admin menu item is displayed
    public boolean isAdminMenuDisplayed() {
        return getAdminMenuElement().isDisplayed();
    }

    // Verifies that the PIM menu item is displayed
    public boolean isPimMenuDisplayed() {
        return getPimMenuElement().isDisplayed();
    }

    // Verifies that the Leave menu item is displayed
    public boolean isLeaveMenuDisplayed() {
        return getLeaveMenuElement().isDisplayed();
    }

    // Verifies that the Time menu item is displayed
    public boolean isTimeMenuDisplayed() {
        return getTimeMenuElement().isDisplayed();
    }

    // Verifies that the Recruitment menu item is displayed
    public boolean isRecruitmentMenuDisplayed() {
        return getRecruitmentMenuElement().isDisplayed();
    }

    // Verifies that the My Info menu item is displayed
    public boolean isMyInfoMenuDisplayed() {
        return getMyInfoMenuElement().isDisplayed();
    }

    // Verifies that the Performance menu item is displayed
    public boolean isPerformanceMenuDisplayed() {
        return getPerformanceMenuElement().isDisplayed();
    }

    // Verifies that the Dashboard menu item is displayed
    public boolean isDashboardMenuDisplayed() {
        return getDashboardMenuElement().isDisplayed();
    }

    // Verifies that the Directory menu item is displayed
    public boolean isDirectoryMenuDisplayed() {
        return getDirectoryMenuElement().isDisplayed();
    }
}
