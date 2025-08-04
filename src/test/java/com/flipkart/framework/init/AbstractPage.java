package com.flipkart.framework.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class AbstractPage extends WebDriverInit{

        public AbstractPage (WebDriver driver) {
            WebDriverInit.driver = driver;
            ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 10);
            PageFactory.initElements(finder , this);
        }
}
