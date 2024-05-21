package com.ect.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ect.pages.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ListenerClass implements ITestListener {

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void configureReport(){
        htmlReporter = new ExtentSparkReporter("ExtentListenerReportDemo.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        // Add system information / environment info to reports
        reports.setSystemInfo("OS","Mac");

        htmlReporter.config().setDocumentTitle("Extent listener Report Demo");
        htmlReporter.config().setReportName("First Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }


    @Override
    public void onStart(ITestContext context) {
        configureReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("The test Started");
        test = reports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Method successful executed: " + result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test Failed: " + result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

        Object testClass = result.getInstance();
        WebDriver driver = ((BaseClass) testClass).driver;

        try {
            String screenshotPath = ((BaseClass) testClass).captureScreenShot(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath);
            File screenShotFile = new File(screenshotPath);
            if(screenShotFile.exists()){
                test.fail("Captured screenshot below" + test.addScreenCaptureFromPath(screenshotPath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped: " + result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Implement this if needed
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }
}
