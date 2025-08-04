package com.flipkart.ui.testClasses;

import com.flipkart.framework.init.WebDriverInit;
import org.testng.annotations.Test;

public class demoTest extends WebDriverInit {

    @Test
    public void sample(){
        System.out.println("Test Running :" + driver.getTitle());
        driver.getTitle();
    }
}
