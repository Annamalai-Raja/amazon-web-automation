package userInteraction.testClasses;

import framework.init.WebDriverInit;
import org.testng.annotations.Test;

public class LoginTest extends WebDriverInit {

    @Test
    public void loginTest(){
       dashboardPO.closeLoginPopUp();
    }

}
