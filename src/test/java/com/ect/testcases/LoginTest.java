package com.ect.testcases;

import com.ect.pages.BaseClass;
import com.ect.pages.CustomerAccountPage;
import com.ect.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test(dataProvider = "loginDataProvider")
    public void LoginTest(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        CustomerAccountPage customerAccountPage = new CustomerAccountPage(driver);
        loginPage.executeLogin(userName, password);
        if(userName.equals("ravi@dhiyotech.in") && password.equals("Demo")){

            Assert.assertTrue(true);

            customerAccountPage.executeLogOut();

        }else {
            Assert.assertTrue(false);
        }
    }
    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        String filePath = "TestData/Data.xlsx";
        String sheetName = "TestLogin";

        return readExelFile.getExcelData(filePath,sheetName);

    }

}
