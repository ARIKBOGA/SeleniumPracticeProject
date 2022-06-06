package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_RadioButton_cont {

    public static void main(String[] args) {

        //TC #2: Radiobutton handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //Locate name='sports' radio buttons and store them in a List of Web Element

        clickAndVerifyRadioButton(driver, "sport", "hockey");

        clickAndVerifyRadioButton(driver, "sport", "football");

        clickAndVerifyRadioButton(driver, "color", "yellow");

        driver.quit();

    }

    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValue) {

        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));

        WebElement optionalWebElement = radioButtons.stream()
                .filter(p -> p.getAttribute("id").equals(idValue))
                .findFirst()
                .orElse(null);

        assert optionalWebElement != null;
        optionalWebElement.click();
        System.out.println(optionalWebElement.getAttribute("id") + " is selected : " + optionalWebElement.isSelected());


    }

}