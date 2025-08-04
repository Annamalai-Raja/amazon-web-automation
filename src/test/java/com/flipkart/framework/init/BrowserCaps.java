package com.flipkart.framework.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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

    public static WebDriver configureBrowser(String browser){
        return switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriver(getChromeOptions());
            case "edge" -> new EdgeDriver(getEdgeOptions());
            case "firefox" -> new FirefoxDriver(getFireFoxOptions());
            default -> throw new IllegalArgumentException("Browser not supported : " + browser);
        };

    }
}
