package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Actions_Hover extends TestBase {

    @Test
    public void hovering_test() {
        //1. Go to https://practice.cydeo.com/hovers
        driver.get("https://practice.cydeo.com/hovers");

        //Locate all images under here:
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        //Locate all the "user" texts under here:
        WebElement user1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement user2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement user3 = driver.findElement(By.xpath("//h5[text()='name: user3']"));

        Actions actions = new Actions(driver);

        //2. Hover over to first image
        BrowserUtils.sleep(2);
        actions.moveToElement(img1).perform();

        //3. Assert:
        //a. “name: user1” is displayed
        Assert.assertTrue(user1.isDisplayed());

        //4. Hover over to second image
        BrowserUtils.sleep(2);
        actions.moveToElement(img2).perform();

        //5. Assert:
        //a. “name: user2” is displayed
        Assert.assertTrue(user2.isDisplayed());

        //6. Hover over to third image
        BrowserUtils.sleep(2);
        actions.moveToElement(img3).perform();

        //7. Confirm:
        //a. “name: user3” is displayed
        Assert.assertTrue(user3.isDisplayed());

        //BREAK UNTIL 3.13PM CST
    }

}
