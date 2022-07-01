package com.qababu.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    ExtentReports extentReport = new ExtentReports();
    ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("ExtentReport.html"); // type of the report

}
