package com.cydeo.tests.day2_locators_getText_getAttribute.homeWorks;

import org.openqa.selenium.By;

import static com.cydeo.tests.Driver.driver;

public class HomeWork3 {
    /*
    TC #3: Back and forth navigation
        1- Open a Chrome browser
        2- Go to: https://google.com
        3- Click to Gmail from top right.
        4- Verify title contains:
            Expected: Gmail
        5- Go back to Google by using the .back(); 6- Verify title equals:
            Expected: Google
     */
    public static void main(String[] args) {
        driver.get("https://google.com");
        driver.findElement(By.linkText("Gmail"))
                .click();
        boolean titleContainsGmail = driver.getTitle().contains("Gmail");

        driver.navigate().back();

        boolean titleEqualsGoogle = driver.getTitle().equals("Google");

        driver.quit();

        System.out.println("titleContainsGmail = " + (titleContainsGmail ? "PASSED" : "FAILED"));
        System.out.println("titleEqualsGoogle = " + (titleEqualsGoogle ? "PASSED" : "FAILED"));
    }
}