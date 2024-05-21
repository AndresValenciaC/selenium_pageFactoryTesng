package com.ect.locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

    @FindBy(xpath = "//input[@id=\"frm_search\"]")
    public WebElement searchShopInput;

    @FindBy(xpath = "//button[@id=\"btn_search\"]")
    public WebElement searchBtn;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[2]/div/div/p/a")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"navbarText\"]/ul/li[3]/a")
    public WebElement cartImageBtn;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[2]/div/div/div/a/h3")
    public WebElement homeProductTitle;

    @FindBy(xpath = "//*[@id=\"cart\"]/div[1]/div/h5")
    public WebElement cartContentsTitle;

    @FindBy(xpath = "//*[@id=\"cart\"]/div[1]/div/div[1]/div/div/div/div[2]/div/div[1]/h6/a")
    public WebElement cartProductTitle;


}
