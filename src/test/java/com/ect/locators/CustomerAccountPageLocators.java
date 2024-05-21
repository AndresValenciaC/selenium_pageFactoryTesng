package com.ect.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerAccountPageLocators {

    @FindBy(xpath = "//div[@id=\"navbarText\"]/ul/li[2]")
    public WebElement loginA_countImage;

    @FindBy(xpath = "//*[@id=\"navbarText\"]/ul/li[2]/div/div/a[2]")
    public WebElement logOutBtn;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div/nav/ol/li[1]/a")
    public WebElement homeHref;

}
