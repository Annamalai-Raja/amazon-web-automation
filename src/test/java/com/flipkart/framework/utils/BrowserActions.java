package com.flipkart.framework.utils;

import com.flipkart.framework.init.WebDriverInit;

public class BrowserActions extends WebDriverInit {

     public static void openUrl(String browser){
        driver.get(browser);
    }

     public static void closeBrowser(){
        driver.quit();
    }
}
