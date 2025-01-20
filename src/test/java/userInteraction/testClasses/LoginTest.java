package userInteraction.testClasses;


import framework.init.WebDriverInit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import  framework.utils.TestLogger;

import static framework.utils.ExtentInit.createTest;
import static framework.utils.TestLogger.*;


public class LoginTest extends WebDriverInit {

    @Test
    public void loginTest(){
        logger =  createTest("Login Test");
        infoLog("Searching For laptop");
        dashboardPO.searchProduct("Laptop");
        //infoLog("Total Results found " + dashboardPO.totalSearchResults());
    }

}
