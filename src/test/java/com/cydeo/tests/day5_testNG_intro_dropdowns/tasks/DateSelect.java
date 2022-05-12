package com.cydeo.tests.day5_testNG_intro_dropdowns.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DateSelect {

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
    public void selectingDateOnDropdownTest() {
        driver.navigate().to("https://practice.cydeo.com/dropdown");

        // creating select menus
        Select dropdownYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select dropdownMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dropdownDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        // selecting date 1923 / December / 1
        dropdownYear.selectByVisibleText("2022");
        dropdownMonth.selectByValue("11");
        dropdownDay.selectByIndex(0);

        // creating isSelected boolean variables
        boolean is2022Selected = driver.findElement(By.xpath("//option[@value='2022']")).isSelected();
        boolean isDecemberSelected = driver.findElement(By.xpath("//select[@id='month']//option[@value='11']")).isSelected();
        boolean is1Selected = driver.findElement(By.xpath("//select[@id='day']//option[@value='1']")).isSelected();

        // Assert all
        Assert.assertTrue(is1Selected);
        Assert.assertTrue(is2022Selected);
        Assert.assertTrue(isDecemberSelected);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

/*
    TC #6: Selecting date on dropdown and verifying
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown
        3. Select “December 1st, 1923” and verify it is selected.
            Select year using : visible text
            Select month using : value attribute
            Select day using : index number
 */