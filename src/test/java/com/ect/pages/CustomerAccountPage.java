package com.ect.pages;

import com.ect.locators.CustomerAccountPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerAccountPage {
    WebDriver driver;
    WebDriverWait wait;
    CustomerAccountPageLocators locators;

    public CustomerAccountPage(WebDriver l_driver) {
        this.driver = l_driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        locators = new CustomerAccountPageLocators();
        PageFactory.initElements(driver, locators);
    }

    public void clickHomeRef() {
        wait.until(ExpectedConditions.elementToBeClickable(locators.homeHref)).click();
    }

    public void executeLogOut() {
        locators.loginA_countImage.click();
        locators.logOutBtn.click();
    }
}
