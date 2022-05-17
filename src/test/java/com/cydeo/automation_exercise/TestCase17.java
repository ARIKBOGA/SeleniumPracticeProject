package com.cydeo.automation_exercise;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase17 {
    static WebDriver driver;


    @BeforeMethod
    public void setDriver() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void TestOfRemovingProductsFromChart() {
        // navigate to web page
        driver.navigate().to("http://automationexercise.com/");

        // verify if that web-site is visible by checking its title
        boolean isVisible = driver.getTitle().equalsIgnoreCase("Automation Exercise");
        Assert.assertTrue(isVisible);


        // find element to add to chart
        WebElement product1 = driver.findElement(By.xpath("(//p[text()='Summer White Top']/..//a)[1]"));
        WebElement product2 = driver.findElement(By.xpath("(//p[text()='Stylish Dress']/..//a)[1]"));
        WebElement product3 = driver.findElement(By.xpath("(//p[text()='Madame Top For Women']/..//a)[1]"));


        // add to chart elements
        List<WebElement> webElementList = new ArrayList<>(List.of(product1, product2, product3));
        webElementList.forEach(p -> {
            p.click();
            HandleWait.staticWait(1);
            driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
            HandleWait.staticWait(1);
        });


        // Click to "Cart" link to check the shopping bag
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[3]/a")).click();

        // verify that Cart page is displayed
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart", "Page couldn't be loaded");


        // a list for elements which is represents price on the html table
        List<WebElement> chartElementPrices = driver.findElements(By.xpath("//tr/td[@class='cart_total']/p"));

        // a list for elements which is presents for delete the element from the html table
        List<WebElement> chartDeleteButtons = driver.findElements(By.xpath("//tr/td[@class='cart_total']/p/../../td[@class='cart_delete']"));


        // a list for elements which are going to be deleted
        List<WebElement> willBeDeleted = new ArrayList<>();

        // if an element has a price more than 600, add that element to "willBeDeleted" list so that will be deleted
        for (int i = 0; i < chartElementPrices.size(); i++) {
            if (Integer.parseInt(chartElementPrices.get(i).getText().substring(4)) > 600) {
                willBeDeleted.add(chartDeleteButtons.get(i));
            }
        }

        // click to "X" button to delete
        willBeDeleted.forEach(p -> {
            p.click();
            HandleWait.staticWait(1);
        });


        // get elements again for checking if they include an element which has price more than 600
        chartElementPrices = driver.findElements(By.xpath("//tr/td[@class='cart_total']/p"));
        boolean isContainsOverLimitPrice = false;


        // check the reminding elements if they include an element which has price more than 600
        for (WebElement price : chartElementPrices) {
            if (Integer.parseInt(price.getText().substring(4)) > 600)
                isContainsOverLimitPrice = true;
        }


        // Assert the boolean status of if still there is an element which has price more than 600
        Assert.assertFalse(isContainsOverLimitPrice);
    }
}