package amazon_ui.pageObjects;

import framework.init.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.utils.TestLogger.testInfoLog;

public class CartPO extends AbstractClass {



    @FindBy(xpath = "//div[contains(@aria-label, 'Quantity')]")
    public WebElement cartItems;

    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
    public WebElement proceedPaymentButton;

    public CartPO(WebDriver driver){
        super(driver);
        this.cartPO = this;
    }

    public boolean _isCartPageRedirected(){
        return proceedPaymentButton.isDisplayed();
    }

    public void addedCartItems(){
        int itemsInCart = Integer.parseInt(cartItems.getText());

        if(itemsInCart>=1){
            testInfoLog("Items Added in cart Successfully -" + itemsInCart);
        }
        else {
            testInfoLog("Items Not Added in cart");
        }
    }

    public void clickProceedPayment(){
        testInfoLog("clicking payment button");
        clickByElement(driver , proceedPaymentButton);
    }
}
