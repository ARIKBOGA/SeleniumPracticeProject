package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitPractices extends TestBase {

    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod() {

        driver.get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();

    }

    @Test
    public void remove_button_test() {
        //3- Click to “Remove” button
        dynamicControlsPage.removeButton.click();

        //4- Wait until “loading bar disappears”
        // driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));

        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed

        try {
            //assertFalse method will pass the test if the boolean value returned is: false
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            Assert.assertTrue(dynamicControlsPage.message.isDisplayed());
        } catch (NoSuchElementException n) {
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        isDisplayedFunction(dynamicControlsPage.message);
        assertEqualsFunction(dynamicControlsPage.message, "It's gone!");
    }

    @Test
    public void enable_button_test() {
        //3- Click to “Enable” button

        //System.out.println("dynamicControlsPage.inputBox.isEnabled() = "
        //        + dynamicControlsPage.inputBox.isEnabled());

        clickFunction(dynamicControlsPage.enableButton);

        System.out.println("dynamicControlsPage.inputBox.isEnabled() = "
                + dynamicControlsPage.inputBox.isEnabled());

        //4- Wait until “loading bar disappears”
        //Calling our ExplicitWait utility method to wait loadingBar to disappear
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        System.out.println("dynamicControlsPage.inputBox.isEnabled() = "
                + dynamicControlsPage.inputBox.isEnabled());

        //5- Verify:
        //a. Input box is enabled.
        isEnabledFunction(dynamicControlsPage.inputBox);

        //b. “It’s enabled!” message is displayed.
        isDisplayedFunction(dynamicControlsPage.message);

        //Check the String value is matching as expected: “It’s enabled!”
        assertEqualsFunction(dynamicControlsPage.message, "It's enabled!");

    }
}