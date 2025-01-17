package framework.init;

import framework.utils.Configuration;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserCaps implements Configuration {
    public static String osName = "";
    public static String browserVersion = "";
    public static String browserName = "";

   static DesiredCapabilities configureChrome(){
       DesiredCapabilities caps = new DesiredCapabilities();
       caps.setCapability(CapabilityType.PLATFORM_NAME , Platform.MAC);
       caps.setCapability(CapabilityType.BROWSER_NAME , "chrome");

       osName = System.getProperty("os.name");
       browserName = caps.getBrowserName();
       browserVersion = caps.getBrowserVersion();

       System.out.println("OS Name :"  + osName);
       System.out.println("Browser Name :"  + browserName);
       System.out.println("Browser Version :"  + browserVersion);

       return caps;
    }

    static URL getGridUrl() {
        try {
            return new URL("http://"+SELENIUM_HUB+":"+SELENIUM_PORT);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Grid URL", e);
        }
    }
}
