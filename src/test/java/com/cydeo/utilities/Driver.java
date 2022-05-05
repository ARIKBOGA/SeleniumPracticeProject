package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    static {
        WebDriverManager.chromedriver().setup();
    }

    public static final WebDriver CHROME_DRIVER = new ChromeDriver();
}