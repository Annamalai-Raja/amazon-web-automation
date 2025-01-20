package amazon_ui.pageObjects;

import framework.init.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.utils.TestLogger.infoLog;

public class DashboardPO extends AbstractClass {

    @FindBy( id = "twotabsearchtextbox")
    public WebElement searchTab;

    @FindBy(xpath = "//input[@type = 'submit']")
    public  WebElement searchButton;

    @FindBy(xpath = "//span[contains(text() , 'results for')]")
    public WebElement totalResults;

    public DashboardPO(WebDriver driver) {
        super(driver);
        this.dashboardPO = this;
    }

    public void searchProduct(String input){
        infoLog("Searching for - " + input);
        sendKeys( searchTab , input);
        infoLog("Clicking Search button");
        clickByElement(driver , searchButton);
    }

    public boolean isProductsDisplayed(){
        return totalResults.isDisplayed();
    }

    public void totalResultsFetched(){
        String result = totalResults.getText();
        infoLog("Total Results found -" +  fetchNumbers(result));
    }

}
