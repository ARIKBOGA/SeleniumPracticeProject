package com.cydeo.seleniumScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeleniumScript7 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("Enter URL here to verify");
        WebElement listBox = driver.findElement(By.name("country"));
        Select select = new Select(listBox);
        List<WebElement> allOptions = select.getOptions();
        ArrayList<String> allText = new ArrayList<>();

        for (WebElement allOption : allOptions) {
            String text = allOption.getText();
            allText.add(text);
        }

        Collections.sort(allText);
        for (String s : allText) {
            System.out.println(s);
        }
    }
}