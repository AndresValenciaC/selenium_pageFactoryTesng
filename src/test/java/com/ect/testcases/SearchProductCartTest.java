package com.ect.testcases;

import com.ect.pages.BaseClass;

import com.ect.pages.CustomerAccountPage;
import com.ect.pages.HomePageUserAccount;
import com.ect.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SearchProductCartTest extends BaseClass {


        @DataProvider(name = "searchProductCartDataProvider")
        public Object[][] SearchProductTestDataProvider() {
            String filePath = "TestData/Data.xlsx";
            String sheetName = "TestLogin";
            String userName = readExelFile.getSingleCellValue(filePath, sheetName, 1, "userName");
            String password = readExelFile.getSingleCellValue(filePath, sheetName, 1, "password");
            return new Object[][]{{userName, password}};
        }

    @Test(dataProvider = "searchProductCartDataProvider")
    public void SearchProductTest(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        CustomerAccountPage cap = new CustomerAccountPage(driver);
        HomePageUserAccount hpu_account = new HomePageUserAccount(driver);

        loginPage.executeLogin(userName, password);
        cap.clickHomeRef();
        hpu_account.executeSearch();

        // Validations
        String homeProductNameText = hpu_account.getHomeProductNameText();

        String cartProductTitleText = hpu_account.getProductTitleText();

        String cartContentsText = hpu_account.getCartContentsText();

        Assert.assertTrue(cartContentsText.contains("Cart contents"), "The text in the cart don`t contain 'Cart contents'");
        Assert.assertEquals(homeProductNameText, cartProductTitleText, "Names don't match");

    }

}
