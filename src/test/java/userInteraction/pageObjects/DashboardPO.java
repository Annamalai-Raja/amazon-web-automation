package userInteraction.pageObjects;

import framework.init.AbstractClass;
import framework.init.WebDriverInit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPO extends AbstractClass {


    @FindBy(xpath = "//span[text() ='✕']")
    public WebElement closeLoginBtn;

    public DashboardPO(WebDriver driver) {
        super(driver);
        this.dashboardPO = new DashboardPO(driver);
    }


    public void closeLoginPopUp(){
        clickByElement(driver , closeLoginBtn);
    }
}
