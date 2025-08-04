package com.flipkart.framework.init;

import com.flipkart.framework.utils.BrowserActions;
import com.flipkart.ui.pageObjects.demoPo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static com.flipkart.framework.utils.BrowserActions.openUrl;
import static com.flipkart.framework.utils.Configurations.APP_URL;

public class WebDriverInit {

    public static WebDriver driver;

    public demoPo demo;

    @BeforeSuite
    public void initReports(){
        System.out.println("Initializing Reports");
    }


    @Parameters("browser")
    @BeforeMethod
    public void initDriver(String browser){
        System.out.println("Initializing Driver");
        BrowserCaps.configureBrowser(browser);
        openUrl(APP_URL);
        demo = new demoPo(driver);
    }

    @AfterMethod
    public void quitDriver(){
        System.out.println("Closing Driver");
    }

    @AfterSuite
    public void flushReports(){
        System.out.println("Flushing Reports");
    }
}
