package framework.init;

import amazon_ui.pageObjects.CartPO;
import amazon_ui.pageObjects.LoginPo;
import com.aventstack.extentreports.markuputils.ExtentColor;
import framework.utils.Configuration;
import org.openqa.selenium.JavascriptExecutor;
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
    protected LoginPo loginPO;
    protected CartPO cartPO;

    @BeforeSuite
    public void initReport(ITestContext context) {
        initializeReports(context.getCurrentXmlTest().getSuite().getName());
    }

    @BeforeMethod
    public void initDriver(ITestContext context) {
        try {
            DesiredCapabilities caps ;

            if (Boolean.parseBoolean(IS_CLOUD)) {
                caps =BrowserCaps.configureCloudBrowser(context.getCurrentXmlTest().getSuite().getName());
                driver = new RemoteWebDriver(BrowserCaps.getRemoteURl() , caps);
            }
            else if(Boolean.parseBoolean(IS_GRID))
            {
                caps = BrowserCaps.configureGridBrowser();
                driver = new RemoteWebDriver(BrowserCaps.getGridUrl(), caps);
            }
            else {
                driver = new ChromeDriver();
            }

            openUrl(driver, URL);
            maximizeWindow(driver);
            implicitWait(driver);

            loginPO = new LoginPo(driver);
            dashboardPO = new DashboardPO(driver);
            cartPO = new CartPO(driver);

        } catch (Exception e) {
            System.err.println("Error initializing WebDriver: " + e.getMessage());
            throw e;
        }
    }

    @AfterMethod
    public void quitDriver(ITestResult result) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if(Boolean.parseBoolean(IS_CLOUD)){
            if (result.getStatus() == ITestResult.SUCCESS){
                js.executeScript( "lambda-status=passed");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                js.executeScript("lambda-status=failed");
            }
            else {
                js.executeScript("lambda-status=skipped");
            }
        }

        else {
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





