package com.cydeo.OscarReview.week6.pomForReview;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ReviewUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task06 {

    private final WebDriver driver = Driver.getDriver();

    private final Faker faker = new Faker();

    @Test
    public void Test() {

        driver.get("http://automationexercise.com/");

        // create object so that we can use elements and methods
        ContactUsPage contactUsPage = new ContactUsPage();

        // click Contact Us
        contactUsPage.getElement("Contact us").click();


        // for scrolling test cases
        // create actions object
        // 1. sendKeys
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        ReviewUtils.staticWait(2);
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();

        // 2. moveToElement
        ReviewUtils.staticWait(2);
        actions.moveToElement(contactUsPage.submit).perform();

        // 3. JavaScriptExecutor window.scrollBy
        ReviewUtils.staticWait(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)");
        ReviewUtils.staticWait(1);
        js.executeScript("window.scrollBy(0,-750)");

        // 4. JavaScriptExecutor scrollIntoView
        ReviewUtils.staticWait(2);
        js.executeScript("arguments[0].scrollIntoView(true)",contactUsPage.submit);


        contactUsPage.name.sendKeys(faker.name().fullName());
        contactUsPage.email.sendKeys(faker.internet().emailAddress());
        contactUsPage.subject.sendKeys(faker.chuckNorris().fact());
        contactUsPage.message.sendKeys(faker.howIMetYourMother().catchPhrase());
        contactUsPage.uploadFile.sendKeys("/Users/burakarikboga/Desktop/new text file.txt");
        contactUsPage.submit.click();

        driver.switchTo().alert().accept();

        String actualSuccessMessage = contactUsPage.successMessage.getText();
        String expectedSuccessMessage = "Success! Your details have been submitted successfully.";
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

        Driver.closeDriver();
    }
}
