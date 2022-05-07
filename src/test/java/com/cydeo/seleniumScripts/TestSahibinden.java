package com.cydeo.seleniumScripts;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Scanner;

public class TestSahibinden {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        System.out.print("Enter city name (English letters): ");
        String cityName = sc.nextLine().toLowerCase();
        System.out.print("Enter max price: ");
        String maxPrice = sc.nextLine();

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        assert driver != null;
        driver.manage().window().maximize();
        driver.get("https://www.sahibinden.com/en");

        // close the cookie suggestion
        driver.findElement(By.xpath("//*[@id=\"onetrust-close-btn-container\"]/button"))
                .click();
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0, 800)");
        Thread.sleep(2000);

        // click to computers link
        driver.findElement(By.cssSelector("a[title='Computers']"))
                .click();
        Thread.sleep(2000);

        // click to computers link
        driver.findElement(By.cssSelector("a[title='Monitors']"))
                .click();
        Thread.sleep(2000);

        // click anywhere to get rid of pop-up add comes from up-right corner
        driver.findElement(By.xpath("//html"))
                .click();
        Thread.sleep(2000);

        // click to "used" radio button
        driver.findElement(By.xpath("//*[@id=\"searchResultLeft-\"]/dl[2]/dd/ul/div/div/li[1]/a/i"))
                .click();
        Thread.sleep(2000);


        // Select the city you wanted to search in
        driver.findElement(By.className("faceted-select")).click();
        Thread.sleep(2000);

        // create special cssSelector with using given city name by user
        String cssSelectorForCity = "li[data-label='" + cityName + "']";

        driver.findElement(By.cssSelector(cssSelectorForCity)).click();
        Thread.sleep(2000);

        // click anywhere to escape city-select menu
        driver.findElement(By.xpath("//html"))
                .click();
        Thread.sleep(3000);


        driver.findElement(By.cssSelector("input[name='price_max']"))
                .sendKeys(maxPrice + Keys.ENTER);
        Thread.sleep(3000);


        js.executeScript("scrollBy(0,1000)");
        Thread.sleep(3000);
        driver.findElement(By.id("_cllpsID_filter-by-keyword")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"searchResultsSearchForm\"]/div/div[2]/div[10]/dl/dd/ul/li/input"))
                .sendKeys("vga" + Keys.ENTER);

        Thread.sleep(5000);

        driver.quit();
    }
}