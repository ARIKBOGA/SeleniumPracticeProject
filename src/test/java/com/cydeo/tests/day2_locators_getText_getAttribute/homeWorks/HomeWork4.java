package com.cydeo.tests.day2_locators_getText_getAttribute.homeWorks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeWork4 {
    /*
        TC #4: Practice Cydeo – Class locator practice
            1- Open a Chrome browser
            2- Go to: https://practice.cydeo.com/inputs
            3- Click to “Home” link
            4- Verify title is as expected:
                Expected: Practice
        PS: Locate “Home” link using “className” locator
     */
    public static void main(String[] args) {
        WebDriver driver = Driver.CHROME_DRIVER;
        driver.get("https://practice.cydeo.com/inputs ");
        driver.findElement(By.className("nav-link")).click();

        System.out.println((driver.getTitle().equals("Practice")) ? "PASSED" : "FAILED");

        //driver.quit();
    }
}