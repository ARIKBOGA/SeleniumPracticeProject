package com.cydeo.tests.day5_testNG_intro_dropdowns.tasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StateSelect {
    WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        //Do browser driver setup
        //Open browser
        driver = WebDriverFactory.getDriver("chrome");

        //Maximize the page
        driver.manage().window().maximize();

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void seleniumTest() throws InterruptedException {

        //Go to http://practice.cybertekschool.com/dropdown
        driver.navigate().to("http://practice.cybertekschool.com/dropdown");

        Select select = new Select( driver.findElement(By.xpath("//select[@id='state']")));

        // selecting Illinois
        select.selectByVisibleText("Illinois");
        Thread.sleep(2000);

        // selecting Virginia
        select.selectByValue("VA");
        Thread.sleep(2000);

        // selecting California
        select.selectByIndex(5);
        Thread.sleep(2000);

        boolean isSelectedCalifornia = driver.findElement(By.xpath("//option[@value='CA']")).isSelected();

        Assert.assertTrue(isSelectedCalifornia);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
/*
        TC #5: Selecting state from State dropdown and verifying result
            1. Open Chrome browser
            2. Go to http://practice.cybertekschool.com/dropdown
            3. Select Illinois
            4. Select Virginia
            5. Select California
            6. Verify final selected option is California.
                Use all Select options. (visible text, value, index)
 */