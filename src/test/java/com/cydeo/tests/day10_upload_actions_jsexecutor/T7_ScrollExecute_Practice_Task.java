package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class T7_ScrollExecute_Practice_Task extends TestBase {

    @FindBy(linkText = "CYDEO")
    private WebElement cydeoLink;
    @FindBy(linkText = "Home")
    private WebElement homeLink;

    @Test
    public void scroll_Execute_Test() {

        PageFactory.initElements(driver, this);

        //TC #7: Scroll using JavascriptExecutor
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/large
        driver.get("https://practice.cydeo.com/large ");

        //3- Scroll down to “Cydeo” link
        executeJavascript("arguments[0].scrollIntoView(true)", cydeoLink);

        //4- Scroll up to “Home” link
        executeJavascript("arguments[0].scrollIntoView(true)", homeLink);

        //5- Use below provided JS method only JavaScript method to use : arguments[0].scrollIntoView(true)
        //Note: You need to locate the links as web elements and pass them as arguments into executeScript() method
    }
}