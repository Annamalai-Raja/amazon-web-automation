package framework.init;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Generics {

    public void openUrl(WebDriver driver , String url){
        driver.get(url);
    }

    public void implicitWait(WebDriver driver , int duration){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }

    public void maximizeWindow(WebDriver driver){
        driver.manage().window().maximize();
    }

    public void clickByElement(WebDriver driver, WebElement element){
        element.click();
    }

    public void sendKeys(WebElement element , String string){
        element.sendKeys(string);
    }

    public void clearField(WebElement element){
        element.clear();
    }

    public void clickByElementJS(WebDriver driver , WebElement element){

        JavascriptExecutor js_executor = (JavascriptExecutor) driver;
        js_executor.executeScript("arguments[0].click();" , element);
    }

    public void deleteCookies(WebDriver driver){
        driver.manage().deleteAllCookies();
    }

    public void quit(WebDriver driver){
        driver.quit();
    }



}
