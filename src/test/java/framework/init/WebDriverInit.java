package framework.init;

import framework.utils.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import userInteraction.pageObjects.DashboardPO;

public class WebDriverInit extends Generics implements Configuration{

    public WebDriver driver;

    protected DashboardPO dashboardPO;


    @BeforeClass
    public void initDriver()  {
        DesiredCapabilities caps = BrowserCaps.configureChrome();

          if(Boolean.parseBoolean(IS_GRID)){
              driver = new RemoteWebDriver(BrowserCaps.getGridUrl() , caps);
          }
         else{
             driver = new ChromeDriver();
          }


        openUrl(driver , URL );
        maximizeWindow(driver);
        implicitWait(driver , 10);

        dashboardPO = new DashboardPO(driver);
    }



    @AfterClass
    public void quitDriver(){
       deleteCookies(driver);
       quit(driver);
    }

    @AfterSuite
    public void exitReports(){

    }
}
