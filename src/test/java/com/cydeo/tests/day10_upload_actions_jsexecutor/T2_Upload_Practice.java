package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice extends TestBase {

    @Test
    public void upload_test() {
        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        driver.get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        String path = "/Users/burakarikboga/Desktop/Presentation1.pptx";

        /*
        String path ="C:\\Users\\hayat\\Desktop\\note.txt";
         */

        //3. Upload the file.
        WebElement fileUpload = driver.findElement(By.id("file-upload"));

        BrowserUtils.sleep(2);

        fileUpload.sendKeys(path);

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        //4. Assert:
        //-File uploaded text is displayed on the page
        WebElement fileUploadedHeader = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedHeader.isDisplayed());

    }
}
