package Utilities;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;
import java.util.UUID;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MyListener implements WebDriverListener {
//    private String startStep(String name) {
//        String uuid = UUID.randomUUID().toString();
//
//        lifecycle.startStep(uuid, new StepResult().setName(name));
//
//        return uuid;
//    }
    private final AllureLifecycle lifecycle = Allure.getLifecycle();
    private final ThreadLocal<String> clickStep = new ThreadLocal<>();
    private final ThreadLocal<String> sendKeysStep = new ThreadLocal<>();
    private final ThreadLocal<String> clearStep = new ThreadLocal<>();
    private final ThreadLocal<String> submitStep = new ThreadLocal<>();
//    private void attachScreenshot(WebDriver driver) {
//
//        byte[] screenshot =
//                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//
//        Allure.addAttachment(
//                "Screenshot",
//                "image/png",
//                new ByteArrayInputStream(screenshot),
//                ".png"
//        );
//    }
    @Override
    public void beforeGetCurrentUrl(WebDriver driver) {
        System.out.println("before GetCurrentUrl");
    }

    @Override
    public void afterGetCurrentUrl(WebDriver driver, String result) {
        System.out.println("after GetCurrentUrl");
    }


    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println("Before FindElement");
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println("After FindElement");
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        System.out.println("Before FindElements");
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        System.out.println("After FindElements");
    }
















    @Override
    public void beforeClick(WebElement element) {
//        String uuid = startStep("Click element");
//
//        clickStep.set(uuid);
        System.out.println("Before Click");
    }

    @Override
    public void afterClick(WebElement element) {
//        String uuid = clickStep.get();
//
//        WebDriver driver = ((WrapsDriver) element).getWrappedDriver();
//
//        byte[] screenshot =
//                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//
//        lifecycle.addAttachment(
//                "Screenshot",
//                "image/png",
//                ".png",
//                screenshot
//        );
//
//        lifecycle.stopStep(uuid);
//
//        clickStep.remove();
        System.out.println("After Click");
    }

    @Override
    public void beforeSubmit(WebElement element) {
//        String uuid = startStep("Submit");

//        submitStep.set(uuid);
        System.out.println("Before Submit");
    }

    @Override
    public void afterSubmit(WebElement element) {
//        String uuid = submitStep.get();
//
//        WebDriver driver = ((WrapsDriver) element).getWrappedDriver();
//
//        byte[] screenshot =
//                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//
//        lifecycle.addAttachment(
//                "Screenshot",
//                "image/png",
//                ".png",
//                screenshot
//        );
//
//        lifecycle.stopStep(uuid);
//
//        submitStep.remove();
        System.out.println("After Submit");
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
//        String uuid = startStep("Before Send Keys");
//
//        clickStep.set(uuid);
        System.out.println("Before SendKeys");

    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
//        String uuid = sendKeysStep.get();
//
//        WebDriver driver = ((WrapsDriver) element).getWrappedDriver();
//
//        byte[] screenshot =
//                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//
//        lifecycle.addAttachment(
//                "Screenshot",
//                "image/png",
//                ".png",
//                screenshot
//        );
//
//        lifecycle.stopStep(uuid);
//
//        clickStep.remove();
        System.out.println("After SendKeys");
    }

    @Override
    public void beforeClear(WebElement element) {
//        String uuid = startStep("clear");
//
//        clearStep.set(uuid);
        System.out.println("Before Clear");
    }

    @Override
    public void afterClear(WebElement element) {
//        String uuid = clearStep.get();
//
//        WebDriver driver = ((WrapsDriver) element).getWrappedDriver();
//
//        byte[] screenshot =
//                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//
//        lifecycle.addAttachment(
//                "Screenshot",
//                "image/png",
//                ".png",
//                screenshot
//        );
//
//        lifecycle.stopStep(uuid);
//
//        clearStep.remove();
        System.out.println("After Clear");
    }





    @Override
    public void beforeGetText(WebElement element) {
//        Allure.step("Before Get Text");
        System.out.println("Before Get Text");

    }

    @Override
    public void afterGetText(WebElement element, String result) {
//        Allure.step("After Get Text");
        System.out.println("After Get Text");
    }

    @Override
    public void beforeFindElement(WebElement element, By locator) {
//        Allure.step("Before Find Element");
        System.out.println("Before Find Element");
    }

    @Override
    public void afterFindElement(WebElement element, By locator, WebElement result) {
//        Allure.step("After Find Element");
        System.out.println("After Find Element");

    }

    @Override
    public void beforeFindElements(WebElement element, By locator) {
//        Allure.step("Before Find Elements");
        System.out.println("Before Find Elements");

    }

    @Override
    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
//        Allure.step("After Find Elements");
        System.out.println("After Find Elements");

    }


    @Override
    public void beforeGetSize(WebElement element) {
//        Allure.step("Before Get Size");
        System.out.println("Before Get Size");

    }

    @Override
    public void afterGetSize(WebElement element, Dimension result) {
//        Allure.step("After Get Size");
        System.out.println("After Get Size");

    }

    @Override
    public void beforeImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {
//        Allure.step("before Implicitly Wait");
        System.out.println("before implicit wait");

    }

    @Override
    public void afterImplicitlyWait(WebDriver.Timeouts timeouts, Duration duration) {
//        Allure.step("after implicit wait");
        System.out.println("after implicit wait");
    }

    public MyListener() {
        super();
    }
}