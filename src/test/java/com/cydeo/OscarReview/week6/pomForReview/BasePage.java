package com.cydeo.OscarReview.week6.pomForReview;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    // first step to construct the POM
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // second step common locators and methods for the application
    @FindBy(linkText = " Contact us")
    public WebElement contactUs;

    @FindBy(tagName = "a")
    public List<WebElement> links;



    public WebElement getElement(String linkText){
        return Driver.getDriver().findElement(By.partialLinkText(linkText));
    }
}
