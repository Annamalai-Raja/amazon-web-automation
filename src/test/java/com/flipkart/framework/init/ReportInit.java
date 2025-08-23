package com.flipkart.framework.init;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.nio.file.spi.FileTypeDetector;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.flipkart.framework.utils.ConfigManager.USER_DIR;

public class ReportInit {

    public static String REPORT_PATH;
    static ExtentReports extent;
    static ExtentSparkReporter htmlReporter;

    public static void initReport(String suiteName) {
        //making common directory to store the reports
        File reportDir = new File(USER_DIR + File.separator + "ExtentReports");
        if (!reportDir.exists()) reportDir.mkdir();

        //making unique directory to store report datewise
        File dateDir = new File(reportDir + File.separator + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
        if(!dateDir.exists()) dateDir.mkdir();

        //making unique directory in time format for each execution
        File timeDir = new File(dateDir+File.separator+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH_mm_ss")));
        if(!timeDir.exists())timeDir.mkdir();

         //Html path for report generation
        REPORT_PATH = timeDir + File.separator + suiteName + ".html";
        //setting up  reporter
        htmlReporter = new ExtentSparkReporter(REPORT_PATH);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Flipkart Automation");
        htmlReporter.config().setReportName("Annamalai");

        //init extent
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setAnalysisStrategy(AnalysisStrategy.TEST);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("User", System.getProperty("user.name"));

    }

    public static void exitReport() {
        extent.flush();
    }
}
