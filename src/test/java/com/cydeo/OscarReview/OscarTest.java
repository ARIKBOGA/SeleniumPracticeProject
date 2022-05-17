package com.cydeo.OscarReview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.cydeo.utilities.WebDriverFactory.getDriver;


public class OscarTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver("chrome");

        driver.navigate().to("https://practice.cydeo.com/forgot_password");

        String expectedEmailValue = "sample@outlook.com";
        driver.findElement(By.xpath("//*[@id=\"forgot_password\"]/div/div/input"))
                .sendKeys(expectedEmailValue);
        String actualEmailValue = driver.findElement(By.xpath("//*[@id=\"forgot_password\"]/div/div/input")).getAttribute("value");
        System.out.println(actualEmailValue.equals(expectedEmailValue));
        Thread.sleep(2000);


        driver.findElement(By.id("form_submit")).click();
        String actualHeader = driver.findElement(By.name("confirmation_message")).getText();
        String expectedHeader = "Your e-mail's been sent!";
        System.out.println(actualHeader.equals(expectedHeader));
        Thread.sleep(2000);

        driver.quit();

    }
}

  /*
     Verify confirmation message
        open Chrome browser
        go to https://practice.cydeo.com/forgot_password
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says 'Your e-mail's been sent!'
     */