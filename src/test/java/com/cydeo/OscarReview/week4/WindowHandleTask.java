package com.cydeo.OscarReview.week4;

import com.cydeo.utilities.HandleWait;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandleTask {
    static WebDriver driver = WebDriverFactory.getDriver("chrome");

    public static void goToWindowHandle(WebDriver driver, String windowHandleString) {
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(windowHandleString))
                break;
        }
    }

    public static void selectYear(WebDriver driver, int year) {
        int currentYear = Integer.parseInt(driver.findElement(By.xpath("//tbody/tr[1]/td[2]/font[1]")).getText().trim());
        if (currentYear == year) return;
        if (currentYear > year) {
            WebElement decreaseYearButton = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/a[1]"));
            for (int i = 0; i < currentYear - year; i++) {
                decreaseYearButton.click();
            }
        } else {
            WebElement increaseYearButton = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/a[2]"));
            for (int i = 0; i < year - currentYear; i++) {
                increaseYearButton.click();
            }
        }
    }

    public static void selectMonth(WebDriver driver, int todayMonth) {
        WebElement selectElement = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/select[1]"));
        Select select = new Select(selectElement);
        select.selectByIndex(todayMonth - 1);
    }

    @BeforeMethod
    public void setDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    private void selectDay(WebDriver driver, int todayDay) {
        String xpath = "//a[contains(text(),'" + todayDay + "')]";
        driver.findElement(By.xpath(xpath)).click();
    }

    @Test
    public void windowHandleTest() {
        driver.navigate().to("https://shino.de/parkcalc/");

        // current windowHandle
        String currentWidowHandle = driver.getWindowHandle();

        // click to the pick a date image for picking starting date
        driver.findElement(By.xpath("//tbody/tr[2]/td[2]/a[1]")).click();

        // switch to pick a date page
        goToWindowHandle(driver, "Pick a Date");

        // create starting date as today
        LocalDate today = LocalDate.now();

        // select starting year
        selectYear(driver, today.getYear());

        // select starting month
        selectMonth(driver, today.getMonthValue());

        // select starting day
        selectDay(driver, today.getDayOfMonth());

        //switch to default windowHandle
        driver.switchTo().window(currentWidowHandle);


        HandleWait.staticWait(2);

        driver.switchTo().defaultContent();
        // click to the pick a date image for picking ending date
        driver.findElement(By.xpath("//tbody/tr[3]/td[2]/a[1]")).click();

        // switch to pick a date page
        goToWindowHandle(driver, "Pick a Date");

        // create ending date as tomorrow
        LocalDate tomorrow = today.plusDays(1);

        // select ending year
        selectYear(driver, tomorrow.getYear());

        // select ending month
        selectMonth(driver, tomorrow.getMonthValue());

        // select ending day
        selectDay(driver, tomorrow.getDayOfMonth());

        HandleWait.staticWait(2);

        //switch to default windowHandle
        driver.switchTo().window(currentWidowHandle);

        // calculate button element
        WebElement calculateButton = driver.findElement(By.xpath("//body/form[1]/input[2]"));
        calculateButton.click();

        String expectedParkingCost = "$ 18.00";
        String actualParkingCost = driver.findElement(By.xpath("//tbody/tr[4]/td[2]/span[1]")).getText();

        Assert.assertEquals(expectedParkingCost, actualParkingCost);
    }
}
/*
    automate the following scenarios for this website https://shino.de/parkcalc/
Scenario 1)
-  Using the Valet parking lot, set today as the entry date & time and tomorrow as the exit giving a full 24 hour window (you can attempt to use the DatePicker).
     */