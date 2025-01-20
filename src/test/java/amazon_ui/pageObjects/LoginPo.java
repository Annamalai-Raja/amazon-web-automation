package amazon_ui.pageObjects;

import framework.init.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static framework.utils.TestLogger.infoLog;

public class LoginPo extends AbstractClass {

    @FindBy(xpath = "//input[@name = 'email']")
    public WebElement userNameField;

    public LoginPo(WebDriver driver){
        super(driver);
        this.loginPO = this;
    }

    public boolean _isLoginPageRedirected(){
        infoLog("After Clicking proceed payment login page Redirected");
        return userNameField.isDisplayed();
    }
}
