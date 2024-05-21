package com.ect.pages;

import com.ect.locators.HomePageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageUserAccount {
    WebDriver driver;
    WebDriverWait wait;
    HomePageLocators homePageLocators;

    public HomePageUserAccount(WebDriver h_driver) {
        this.driver = h_driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        homePageLocators = new HomePageLocators();
        PageFactory.initElements(driver, homePageLocators);
    }


    public void executeSearch() {
        homePageLocators.searchShopInput.sendKeys("tv");
        homePageLocators.searchBtn.click();
        homePageLocators.addToCartBtn.click();
        homePageLocators.cartImageBtn.click();
    }

    public String getHomeProductNameText() {
        return wait.until(ExpectedConditions.visibilityOf(homePageLocators.homeProductTitle)).getText();
    }
    public String getCartContentsText() {
        return wait.until(ExpectedConditions.visibilityOf(homePageLocators.cartContentsTitle)).getText();
    }

    public String getProductTitleText() {
        return wait.until(ExpectedConditions.visibilityOf(homePageLocators.cartProductTitle)).getText();
    }
}
