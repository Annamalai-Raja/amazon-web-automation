package amazon_ui.pageObjects;

import framework.init.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static framework.utils.TestLogger.testInfoLog;

public class LoginPo extends AbstractClass {

    @FindBy(xpath = "//input[@name = 'email']")
    public WebElement userNameField;

    public LoginPo(WebDriver driver){
        super(driver);
        this.loginPO = this;
    }

    public boolean _isLoginPageRedirected(){
        testInfoLog("After Clicking proceed payment login page Redirected");
        new WebDriverWait(driver , Duration.ofSeconds(7)).until(ExpectedConditions.elementToBeClickable(userNameField));
        return userNameField.isDisplayed();
    }
}
