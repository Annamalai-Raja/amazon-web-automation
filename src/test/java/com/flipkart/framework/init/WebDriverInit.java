package com.flipkart.framework.init;

import com.flipkart.ui.pageObjects.SearchPo;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import static com.flipkart.framework.init.BrowserCaps.configureBrowser;
import static com.flipkart.framework.utils.BrowserActions.closeBrowser;
import static com.flipkart.framework.utils.BrowserActions.openUrl;
import static com.flipkart.framework.utils.ConfigManager.APP_URL;

public class WebDriverInit {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public SearchPo searchPo;

    @BeforeSuite
    public void initReports(ITestContext context){
        System.out.println("Initializing Reports");
        String suiteName = context.getSuite().getName();
        ReportInit.initReport(suiteName);
    }

    @Parameters("browser")
    @BeforeMethod
    public void initDriver(String browser){
        System.out.println("Initializing Driver");
        driver = configureBrowser(browser);
        openUrl(APP_URL);
        searchPo = new SearchPo(driver);
    }

    @AfterMethod
    public void quitDriver(){
        System.out.println("Closing Driver");
        closeBrowser();
    }

    @AfterSuite
    public void flushReports(){
        System.out.println("Flushing Reports");
        ReportInit.exitReport();
    }
}
