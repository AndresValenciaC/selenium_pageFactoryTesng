package com.ect.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
    @FindBy(xpath = "//*[@id=\"navbarText\"]/ul/li[2]/a")
    public WebElement loginPageImage;

    @FindBy(id = "email")
    public WebElement loginEmailInput;

    @FindBy(id = "password")
    public WebElement loginPassInput;

    @FindBy(id = "customerloginForm")
    public WebElement signInBtn;


}
