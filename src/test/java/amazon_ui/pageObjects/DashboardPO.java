package amazon_ui.pageObjects;

import framework.init.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static framework.utils.TestLogger.infoLog;

public class DashboardPO extends AbstractClass {

    @FindBy( id = "twotabsearchtextbox")
    public WebElement searchTab;

    @FindBy(xpath = "//input[@type = 'submit']")
    public  WebElement searchButton;

    @FindBy(xpath = "//span[contains(text() , 'results for')]")
    public WebElement totalResults;

    @FindBy(xpath = "//button[text() = 'Add to cart']")
    public List<WebElement> addCartButton;

    @FindBy(xpath = "//span[@class='nav-line-2'][normalize-space()='Cart']")
    public WebElement cartButton;

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

    public boolean _isProductsDisplayed(){
        return totalResults.isDisplayed();
    }

    public void totalResultsFetched(){
        String result = totalResults.getText();
        infoLog("Total Results found -" +  fetchNumbers(result));
    }

    public void clickAddToCart(){
        infoLog("Adding the First product to cart");
        clickByElement(driver , addCartButton.get(0));
        clickByElementJS(driver , cartButton);
    }

}
