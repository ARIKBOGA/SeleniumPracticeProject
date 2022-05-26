package com.cydeo.OscarReview;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OscarTest3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.demoblaze.com/index.html");
        driver.findElement(By.partialLinkText("Laptops")).click();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Sony vaio i5")).click();
        Thread.sleep(4000);
        String actualPrice = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h3")).getText().substring(1, 4);
        String expectedPrice = "790";
        //System.out.println(actualPrice);
        System.out.println(expectedPrice.equals(actualPrice));
        driver.quit();

    }
}
/*
You have to implement the following Web automated checks over our DEMO ONLINE SHOP:
    https://www.demoblaze.com/index.html
    • Customer navigation through product categories: Phones, Laptops and Monitors
    Navigate to "Laptop" → "Sony vaio i5" and verify the price is 790 dollars
 */