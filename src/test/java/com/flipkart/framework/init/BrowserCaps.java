package com.flipkart.framework.init;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.flipkart.framework.utils.ConfigManager.*;

public class BrowserCaps {

    public static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        return options;
    }

    public static EdgeOptions getEdgeOptions(){
        EdgeOptions options =new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--inprivate");
        options.addArguments("--disable-notifications");
        return options;
    }

    public static FirefoxOptions getFireFoxOptions(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--private");
        options.addArguments("--start-maximized");
        options.addPreference("web.notification.enabled" , false);
        return options;
    }

    public static MutableCapabilities getChromeCaps() {
        MutableCapabilities browserstackOptions = new MutableCapabilities();
        browserstackOptions.setCapability("os", "Windows");
        browserstackOptions.setCapability("osVersion", "11");
        browserstackOptions.setCapability("buildName", "My Selenium Build");
        browserstackOptions.setCapability("sessionName", "Chrome Test");

        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("bstack:options", browserstackOptions);

        return capabilities;
    }

    public static WebDriver configureBrowser(String browser) {

        if (EXECUTION_MODE.equalsIgnoreCase("remote")){
            URL hubUrl = null;
            try {
                hubUrl = new URL("https://" + BS_USERNAME + ":" + BS_Password + "@hub-cloud.browserstack.com/wd/hub");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            return new RemoteWebDriver(hubUrl, getChromeCaps());
        }
        else {
            return switch (browser.toLowerCase()) {
                case "chrome" -> new ChromeDriver(getChromeOptions());
                case "edge" -> new EdgeDriver(getEdgeOptions());
                case "firefox" -> new FirefoxDriver(getFireFoxOptions());
                default -> throw new IllegalArgumentException("Browser not supported : " + browser);
            };
        }

    }
}
