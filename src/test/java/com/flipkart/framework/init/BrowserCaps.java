package com.flipkart.framework.init;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.sound.midi.Soundbank;

import static com.flipkart.framework.init.WebDriverInit.driver;

public class BrowserCaps {

    public static void  configureBrowser(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else{
            System.out.println(browser +" : is not supported by the framework");
        }
    }
}
