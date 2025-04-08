package com.personal.advancedsearch.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager implements ITestListener {

    private static ExtentReports extent;
    private static ExtentSparkReporter spark;
    private static ExtentTest test;
    private static String reportName;

    @Override
    public void onStart(ITestContext context) {
        new File("reports").mkdirs(); // <-- auto-create reports folder if missing
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        reportName = "Test-Report-" + timeStamp + ".html";

        spark = new ExtentSparkReporter("reports/Test-Report.html" + reportName);
        spark.config().setDocumentTitle("NopCommerce UI Test Report");
        spark.config().setReportName("Advanced Search UI Validation");
        spark.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Project", "NopCommerce");
        extent.setSystemInfo("Module", "Advanced Search");
        extent.setSystemInfo("Tester", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.PASS, "\u2705 Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.FAIL, "\u274C Test failed: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, result.getThrowable());

        String path = "./screenshots/" + result.getMethod().getMethodName() + ".png";
        test.addScreenCaptureFromPath(path, "Failed Screenshot");

    }







    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.SKIP, "\u26A0\uFE0F Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

        // Auto open report after execution
        try {
            Desktop.getDesktop().browse(new File("./reports/" + reportName).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
