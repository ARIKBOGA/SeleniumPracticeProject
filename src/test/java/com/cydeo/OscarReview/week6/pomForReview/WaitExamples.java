package com.cydeo.OscarReview.week6.pomForReview;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WaitExamples {

    private WebDriver driver;

    // initializing will be done in the @BeforeMethod every time for each test
    private WaitTasksPage waitTasksPage;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        waitTasksPage = new WaitTasksPage(); // initialize
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void tearDown() {
        // screenshot option - if the test case fails we need to take screenshot
        Driver.closeDriver();
    }

    @Test
    public void test_01() {
        waitTasksPage.alertActivate.click();

        wait.until(ExpectedConditions.alertIsPresent());

    }

    @Test
    public void test_02() {
        //  Task2:
        //   1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
        //   2. Click on "Enable button after 10 seconds"
        waitTasksPage.enable.click();

        //   3. Explicitly wait until the button is enabled
        wait.until(ExpectedConditions.elementToBeClickable(waitTasksPage.disable));

        //   4. Then verify the button is enabled
        Assert.assertTrue(waitTasksPage.disable.isEnabled());

    }


}
