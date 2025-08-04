package com.flipkart.ui.pageObjects;


import com.flipkart.framework.init.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class demoPo extends AbstractPage {

    public demoPo(WebDriver driver) {
        super(driver);
    }

    public void openBrowser(){
        driver.get("https://www.flipkart.com/");
    }

}
