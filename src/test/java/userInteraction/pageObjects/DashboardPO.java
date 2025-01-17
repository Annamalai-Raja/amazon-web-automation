package userInteraction.pageObjects;

import framework.init.AbstractClass;
import framework.init.WebDriverInit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DashboardPO extends AbstractClass {


    @FindBy(xpath = "//span[text() ='✕']")
    public WebElement closeLoginBtn;

    @FindBy(name = "q")
    public WebElement searchTab;

    @FindBy(xpath = "//span[contains(text() , 'results for')]")
    public  WebElement totalResults;

    public DashboardPO(WebDriver driver) {
        super(driver);
        this.dashboardPO = this;
    }


    public void closeLoginPopUp(){
        clickByElement(driver , closeLoginBtn);
    }

    public void searchProduct(String input){
        sendKeys( searchTab , input);

    }

    public String totalSearchResults(){
       return totalResults.getText();
    }

}
