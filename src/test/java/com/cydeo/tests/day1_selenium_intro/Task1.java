package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.yahoo.com");

        String currentTitle = driver.getTitle();

        if(currentTitle.equals("Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos")){
            System.out.println("PASSED");
        }else {
            System.err.println("FAILED");
        }

        Thread.sleep(1000);

        driver.quit();
    }
}