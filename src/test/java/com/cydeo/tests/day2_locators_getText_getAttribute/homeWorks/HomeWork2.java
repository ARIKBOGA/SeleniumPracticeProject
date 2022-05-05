package com.cydeo.tests.day2_locators_getText_getAttribute.homeWorks;

import org.openqa.selenium.By;

import static com.cydeo.tests.Driver.driver;

public class HomeWork2 {
    /*
    TC #2: Zero Bank header verification
        1. Open Chrome browser
        2. Go to http://zero.webappsecurity.com/login.html
        3. Verify header text
            Expected: “Log in to ZeroBank”
     */
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://zero.webappsecurity.com/login.html");
        String actualHeader = driver
                .findElement(By.tagName("h3"))
                .getText();

        String expectedHeader = "Log in to ZeroBank";

        System.out.println(expectedHeader.equals(actualHeader) ? "PASSED" : "FAILED");

        Thread.sleep(3000);

        driver.quit();
    }
}