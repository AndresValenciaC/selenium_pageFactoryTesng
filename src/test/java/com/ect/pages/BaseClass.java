package com.ect.pages;

import com.ect.utilities.BrowserFactory;
import com.ect.utilities.ConfigDataClass;
import com.ect.utilities.ReadExelFile;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class BaseClass {
    public WebDriver driver;
    public ConfigDataClass configDataClass = new ConfigDataClass();
    public ReadExelFile readExelFile = new ReadExelFile();

    @BeforeClass
    public void setUp() {
        driver = BrowserFactory.startApplication(driver, configDataClass.getBrowser(), configDataClass.getUrl());
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }

    public String captureScreenShot(WebDriver driver, String testName) throws IOException {
        // Convert Web driver object to TakeScreenshot
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        // Capture image file
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        String screenshotPath = "ScreenShots/"+testName+".png";
        File dest = new File(screenshotPath);
        // Copy image file to destination
        FileUtils.copyFile(src, dest);
        return screenshotPath;
    }

}
