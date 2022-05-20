package com.cydeo.OscarReview.week4;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTask {
    static WebDriver driver = WebDriverFactory.getDriver("chrome");

    @BeforeMethod
    public void setDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void iframeTest() {
        //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        //2. Switch to iframe.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(iframe);

        //3. Get the text “Double-click me to change my text color.” and verify the text
        WebElement p_element_iframe = driver.findElement(By.xpath("//p[text()='Double-click me to change my text color.']"));

        String expectedIframeText = "Double-click me to change my text color.";
        String actualIframeText = p_element_iframe.getText();

        Assert.assertTrue(actualIframeText.startsWith(expectedIframeText));
        Assert.assertEquals(expectedIframeText, actualIframeText,"Actual and expected Text do not match");
    }
}