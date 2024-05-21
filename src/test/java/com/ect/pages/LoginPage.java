package com.ect.pages;

import com.ect.locators.CustomerAccountPageLocators;
import com.ect.locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    LoginPageLocators loginPageLocators;

    public LoginPage(WebDriver l_driver) {
        this.driver = l_driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        loginPageLocators = new LoginPageLocators();
        PageFactory.initElements(driver, loginPageLocators);
    }

    public void executeLogin(String userName, String userPassword) {
        wait.until(ExpectedConditions.elementToBeClickable(loginPageLocators.loginPageImage)).click();
        wait.until(ExpectedConditions.visibilityOf(loginPageLocators.loginEmailInput)).sendKeys(userName);
        loginPageLocators.loginPassInput.sendKeys(userPassword);
        loginPageLocators.signInBtn.click();

        WebDriverWait nextPageWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        nextPageWait.until(ExpectedConditions.urlContains("http://ect.itlearn360.com/customer/account"));

    }

}
