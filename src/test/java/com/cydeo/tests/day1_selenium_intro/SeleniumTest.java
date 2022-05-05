package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        // 1- Setting up the WebDriver Manager
        WebDriverManager.chromedriver().setup();

        // 2- Create instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // 3- Test if driver is working as expected
        driver.get("https://www.yahoo.com");

        String title = driver.getTitle();

        System.out.println(title);
        Thread.sleep(3000);

        driver.navigate().to("https://www.idata.com.tr");
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(3000);

        driver.navigate().forward();
        Thread.sleep(3000);

        driver.navigate().to("https://www.javatpoint.com/");
        Thread.sleep(1000);

        //Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //Scroll down the webpage by 5000 pixels
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0, 5000)");
        Thread.sleep(3000);

        // Click on the Search button
        driver.findElement(By.linkText("Java")).click();
        Thread.sleep(3000);

        driver.quit();
    }
}
