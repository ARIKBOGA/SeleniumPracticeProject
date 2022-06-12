package com.cydeo.tests.base;

import com.cydeo.utilities.Driver;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public abstract class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setupDriver() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                //noinspection UnstableApiUsage
                Files.move(screenshot, new File("src/test/resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Driver.closeDriver();
    }

    public void clickFunction(WebElement clickElement) {
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        clickElement.click();
    }

    public void sendKeysFunction(WebElement sendKeysElement, String value) {
        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.sendKeys(value);
    }

    public void selectElementFunction(WebElement dropdown, String visibleText) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    public void assertEqualsFunction(WebElement alertMessageElement, String expectedMessage) {
        wait.until(ExpectedConditions.visibilityOf(alertMessageElement));
        Assert.assertEquals(alertMessageElement.getText(), expectedMessage);
        System.out.println("My message: " + alertMessageElement.getText());
    }

    public void isDisplayedFunction(WebElement assertTrueElement) {
        wait.until(ExpectedConditions.visibilityOf(assertTrueElement));
        Assert.assertTrue(assertTrueElement.isDisplayed());
    }

    public void isEnabledFunction(WebElement assertTrueElement) {
        wait.until(ExpectedConditions.visibilityOf(assertTrueElement));
        Assert.assertTrue(assertTrueElement.isEnabled());
    }

    public void executeJavascriptFunction(String script, WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, element);
    }

    public void actionsMoveElementFunction(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void actionsSendKeysFunction(Keys... keys) {
        Actions actions = new Actions(driver);
        actions.sendKeys(keys).perform();
    }

}