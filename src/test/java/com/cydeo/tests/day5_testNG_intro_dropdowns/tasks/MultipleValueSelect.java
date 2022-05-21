package com.cydeo.tests.day5_testNG_intro_dropdowns.tasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultipleValueSelect {

    private static final WebDriver driver;

    static {
        // Driver class is my own utility class to provide WebDriver as default
        driver = WebDriverFactory.getDriver("chrome");
    }

    @BeforeMethod
    public void setDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void selectingMultipleValueOnDropdown() throws InterruptedException {

        // navigate to web page which is going to be tested
        driver.navigate().to("https://practice.cydeo.com/dropdown");

        // create select menu
        Select multipleSelectMenu = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));


        // get all options to a list
        List<WebElement> options = multipleSelectMenu.getOptions();
        Thread.sleep(2000);

        // select all options by clicking
        options.forEach(WebElement::click);
        Thread.sleep(2000);


        // print all selected options' texts
        multipleSelectMenu.getAllSelectedOptions().forEach(WebElement::getText);
        Thread.sleep(2000);


        // deselect all options
        options.forEach(WebElement::click);
        Thread.sleep(2000);


        // get all selected options count
        boolean isAllDeselected = multipleSelectMenu.getAllSelectedOptions().size() == 0;


        // verify all options is deselected
        Assert.assertTrue(isAllDeselected);

    }
}
/*
    TC #8: Selecting value from multiple select dropdown
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown
        3. Select all the options from multiple select dropdown.
        4. Print out all selected values.
        5. Deselect all values.
 */