package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportSetup {
    public static ExtentReports extent;
    public static ExtentReports setupExtentReport(String reportTitle, String reportName){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);

        String reportPath = System.getProperty("user.dir")+ "/target/ExecutionReport/E-Report_"+actualDate+".html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

        extent = new ExtentReports();
        extent.attachReporter(spark);

        spark.config().setDocumentTitle(reportTitle);
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName(reportName);

        return extent;
    }
}
