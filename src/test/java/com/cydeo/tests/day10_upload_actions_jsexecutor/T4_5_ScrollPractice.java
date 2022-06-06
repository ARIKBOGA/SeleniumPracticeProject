package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class T4_5_ScrollPractice extends TestBase {

    @FindBy(xpath = "//a[.='Home']")
    private WebElement homeLink;
    @FindBy(xpath = "//a[.='CYDEO']")
    private WebElement poweredByCydeoLink;
    @FindBy(xpath = "//a[.='Hovers']")
    private WebElement hoversLink;

    @Test
    public void scrollPractice_Test() {

        PageFactory.initElements(driver, this);

        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        executeJavascriptFunction("arguments[0].scrollIntoView(true)",poweredByCydeoLink);
        BrowserUtils.sleep(1);

        //4- Scroll using Actions class “moveTo(element)” method
        actionsMoveElementFunction(hoversLink);
        BrowserUtils.sleep(2);

        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button
        actionsMoveElementFunction(homeLink);
        BrowserUtils.sleep(3);
    }
}