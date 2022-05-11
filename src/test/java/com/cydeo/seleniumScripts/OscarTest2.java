package com.cydeo.seleniumScripts;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OscarTest2 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.navigate().to("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        System.out.println(driver.getTitle().equals("Web Orders Login") ? "PASSED" : "FAILED");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        System.out.println(driver.getTitle().equals("Web Orders") ? "PASSED" : "FAILED");

        driver.quit();
    }
}
/*
- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
- Verify title equals: String expectedTitle = "Web Orders Login"
- Enter username: Tester
- Enter password: test
- Click “Sign In” button
- Verify title equals: String expectedHomePageTitle = "Web Orders"
 */