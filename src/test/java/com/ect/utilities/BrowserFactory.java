package com.ect.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browser, String url) {
        try {
            if (browser.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--start-maximized");
                driver = new FirefoxDriver(options);
            } else {
                System.out.println("No supported browser specified");
                return null;
            }

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get(url);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error starting the application with browser: " + browser);
        }

        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }


}
