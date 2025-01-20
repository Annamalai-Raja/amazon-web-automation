package framework.init;

import com.aventstack.extentreports.markuputils.ExtentColor;
import framework.utils.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import amazon_ui.pageObjects.DashboardPO;
import static framework.utils.TestLogger.logger;

import static framework.utils.ExtentInit.initializeReports;
import static framework.utils.ExtentInit.quitReport;

public class WebDriverInit extends Generics implements Configuration {

    public WebDriver driver;
    protected DashboardPO dashboardPO;

    @BeforeSuite
    public void initReport(ITestContext context) {
        initializeReports(context.getCurrentXmlTest().getSuite().getName());
    }

    @BeforeMethod
    public void initDriver() {
        try {
            DesiredCapabilities caps = BrowserCaps.configureChrome();

            if (Boolean.parseBoolean(IS_GRID)) {
                driver = new RemoteWebDriver(BrowserCaps.getGridUrl(), caps);
            } else {
                driver = new ChromeDriver();
            }

            openUrl(driver, URL);
            maximizeWindow(driver);
            implicitWait(driver, 10);

            dashboardPO = new DashboardPO(driver);
        } catch (Exception e) {
            System.err.println("Error initializing WebDriver: " + e.getMessage());
            throw e;
        }
    }

    @AfterMethod
    public void quitDriver(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.SUCCESS) {
                logger.pass(result.getName() + " - PASSED");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                logger.fail(result.getName() + " - FAILED");
                logger.fail("Reason: " + result.getThrowable());
                logger.fail(String.valueOf(ExtentColor.RED));
            } else if (result.getStatus() == ITestResult.SKIP) {
                logger.skip(result.getName() + " - SKIPPED");
                logger.skip(String.valueOf(ExtentColor.ORANGE));
            }
            deleteCookies(driver);
        } finally {
             {
                quit(driver);
            }
        }
    }

    @AfterSuite
    public void exitReports() {
        try {
            quitReport();
        } catch (Exception e) {
            System.err.println("Error finalizing reports: " + e.getMessage());
        }
    }
}
