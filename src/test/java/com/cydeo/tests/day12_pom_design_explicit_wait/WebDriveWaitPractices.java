package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.DynamicLoad1Page;
import com.cydeo.pages.DynamicLoad7Page;
import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class WebDriveWaitPractices extends TestBase {

    @Test
    public void dynamic_load_7_test() {
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        driver.get("https://practice.cydeo.com/dynamic_loading/7");

        //2. Wait until title is "Dynamic title"
        //use the "wait" object(from parent class) to create our expected condition
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //Create object of DynamicLoad7Page to reach and assert web elements
        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();

        //3. Assert: Message “Done” is displayed.
        isDisplayedFunction(dynamicLoad7Page.doneMessage);

        //4. Assert: Image is displayed
        isDisplayedFunction(dynamicLoad7Page.spongeBobImage);

    }

    @Test(priority = 1)
    public void dynamic_load_1_test() {
        //1. Go to https://practice.cydeo.com/dynamic_loading/1
        driver.get("https://practice.cydeo.com/dynamic_loading/1");

        DynamicLoad1Page dynamicLoad1Page = new DynamicLoad1Page();


        //2. Click to start
        clickFunction(dynamicLoad1Page.startButton);


        //3. Wait until loading bar disappears
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));

        //4. Assert username inputbox is displayed
        //5. Enter username: "tomsmith"
        sendKeysFunction(dynamicLoad1Page.inputUsername, "tomsmith");

        //6. Enter password: "incorrectpassword"
        sendKeysFunction(dynamicLoad1Page.inputPassword, "incorrectpassword");


        //7. Click to Submit button
        clickFunction(dynamicLoad1Page.submitButton);

        //8. Assert “Your password is invalid!” text is displayed.
        assertEqualsFunction(dynamicLoad1Page.errorMessage, "Your password is invalid!\n" + "×");
    }
}