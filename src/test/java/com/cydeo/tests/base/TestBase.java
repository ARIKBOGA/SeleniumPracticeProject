package com.cydeo.tests.base;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setupDriver() {
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}
