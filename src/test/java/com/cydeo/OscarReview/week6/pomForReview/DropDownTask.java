package com.cydeo.OscarReview.week6.pomForReview;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownTask {

    private WebDriver driver;
    private WebDriverWait wait;

    // Task3:
    //    1. Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //    2. Login with username: Tester, password: test
    //    3. Click  Order button
    //    4. Verify under Product Information, selected option is “MyMoney”
    //    5. Then select FamilyAlbum, make quantity 2, and click Calculate,
    //    6. Then verify Total is equal to Quantity*PricePerUnit

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void tearDown() {
        // screenshot option - if the test case fails we need to take screenshot
        Driver.closeDriver();
    }

    @Test
    public void test_03() {


        // log in
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);

        // click to order
        driver.findElement(By.linkText("Order")).click();

        // Verify under Product Information, selected option is “MyMoney”
        Select dropDown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "MyMoney");

        // select FamilyAlbum make quantity 2, and click Calculate,
        dropDown.selectByVisibleText("FamilyAlbum");
        driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.BACK_SPACE+"2");
        BrowserUtils.sleep(2);
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),"FamilyAlbum");


    }
}
