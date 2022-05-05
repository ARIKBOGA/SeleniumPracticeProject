package com.cydeo.tests.day2_locators_getText_getAttribute.homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork1 {
    public static void main(String[] args) throws InterruptedException {
        /*
            TC #1: Etsy Title Verification
            1. Open Chrome browser
            2. Go to https://www.etsy.com
            3. Search for “wooden spoon”
            4. Verify title:
            Expected: “Wooden spoon | Etsy”
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage()
                .window()
                .maximize();

        driver.get("https://www.etsy.com");

        driver.findElement(By.id("global-enhancements-search-query"))
                .sendKeys("wooden spoon" + Keys.ENTER);

        /** This (below) element can be used instead of "Keys.ENTER" */
        // WebElement searchButton = driver.findElement(By.cssSelector(".wt-input-btn-group .wt-input-btn-group__btn"));
        // searchButton.click();

        WebElement found = driver.findElement(By.partialLinkText("Wooden Spoon"));

        if (found != null)
            System.out.println("Wooden spoon have been found : PASSED");
        else
            System.out.println("FAILED");

        Thread.sleep(3000);

        driver.close();
        driver.quit();

    }
}