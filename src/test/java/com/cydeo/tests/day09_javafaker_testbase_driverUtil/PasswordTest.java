package com.cydeo.tests.day09_javafaker_testbase_driverUtil;

import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasswordTest {
    static WebDriver driver;

    @Test
    public void passTest() {
        //driver = Driver.getDriver();
        String validPassword = ConfigurationReader.getProperty("validPassword");
        String invalidPassword = ConfigurationReader.getProperty("invalidPassword");

        List<String> list = new ArrayList<>(Arrays.asList(validPassword, invalidPassword));

        for (String each : list) {

            boolean containsDigit = false;
            boolean containsLetter = false;


            for (int i = 0; i < each.length(); i++) {
                if (Character.isDigit(each.charAt(i))) containsDigit = true;
                if (Character.isLetter(each.charAt(i))) containsLetter = true;
                if (containsDigit && containsLetter) break;
            }
            System.out.println(each + ": " + (containsDigit && containsLetter));
            Assert.assertTrue((containsDigit && containsLetter));
        }
    }
}
