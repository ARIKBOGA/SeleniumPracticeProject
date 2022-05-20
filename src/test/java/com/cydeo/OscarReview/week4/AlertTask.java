package com.cydeo.OscarReview.week4;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTask {

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
    public void alertTest() {
        driver.navigate().to("https://www.demoblaze.com/index.html");
        driver.findElement(By.xpath("//a[text()='Laptops']")).click();
        driver.findElement(By.xpath("//a[text()='Sony vaio i5']")).click();
        driver.findElement(By.xpath("//a[text()='Add to cart']")).click();

        HandleWait.staticWait(1);

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}

 /*
    You have to implement the following Web automated checks over our DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
        • Customer navigation through product categories: Phones, Laptops and Monitors
        • Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
     */