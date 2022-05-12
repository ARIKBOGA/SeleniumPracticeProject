package com.cydeo.tests.day5_testNG_intro_dropdowns.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ValueSelect {
    private static final WebDriver driver;

    static {
        // Driver class is my own utility class to provide WebDriver as default
        driver = Driver.CHROME_DRIVER;
    }

    @BeforeMethod
    public void setDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void selectingDateOnDropdownTest() throws InterruptedException {

        // navigate to web page which is going to be tested
        driver.navigate().to("https://practice.cydeo.com/dropdown");

        // click dropdown link to see website options
        driver.findElement(By.xpath("//a[@id='dropdownMenuLink']")).click();
        Thread.sleep(2000);

        // click to Facebook
        driver.findElement(By.xpath("//a[.='Facebook']")).click();

        // get title from Facebook webpage
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook – log in or sign up";

        // compare expected and actual results
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
/*
    TC #7: Selecting value from non-select dropdown
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown
        3. Click to non-select dropdown
        4. Select Facebook from dropdown
        5. Verify title is “Facebook - Log In or Sign Up”
 */