package com.cydeo.tests.base;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setupDriver() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
    }


    @AfterMethod
    public void tearDown() {
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

    public void assertionFunction(WebElement alertMessageElement, String expectedMessage) {
        wait.until(ExpectedConditions.visibilityOf(alertMessageElement));
        Assert.assertEquals(alertMessageElement.getText(), expectedMessage);
        System.out.println("My message: " + alertMessageElement.getText());
    }

    public void executeJavascriptFunction(String script, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, element);
    }

    public void actionsMoveElementFunction(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void actionsSendKeysFunction(Keys... keys) {
        Actions actions = new Actions(driver);
        actions.sendKeys(keys).perform();
    }

}