package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T3_XpathLocatorPractice {

    static WebDriver driver;

    public static void main(String[] args) {

        //TC #6:  XPATH LOCATOR practice
        //1. Open Chrome browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");

        //3. Click on Button 1
        String buttonText = "Button 1";
        WebElement button = getButton(buttonText);
        button.click();
        //WebElement button = driver.findElement(By.xpath("//button[.='" + buttonText + "']"));
        //button.click();

        //4. Verify text displayed is as expected:
        //Expected: “Clicked on button one!”

        if ((driver.findElement(By.xpath("//p[@id='result']")).getText()).equals("Clicked on button one!")) {
            System.out.println("Verification PASSED!");
        } else {
            System.out.println("Verification FAILED!");
        }

        driver.close();

    }

    public static WebElement getButton(String buttonText) {
        return driver.findElement(By.xpath("//button[.='" + buttonText + "']"));
    }

}