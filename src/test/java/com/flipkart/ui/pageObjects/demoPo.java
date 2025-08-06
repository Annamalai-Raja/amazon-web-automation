package com.flipkart.ui.pageObjects;


import com.flipkart.framework.init.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demoPo extends AbstractPage {

    @FindBy(xpath = "//button[text() ='Request OTP']")
    WebElement otpDialogBox;

    @FindBy(xpath = " //span[text() ='✕']")
    WebElement btnClose;

    @FindBy(css = "[name=\"q\"]")
    WebElement searchBox;

    @FindBy(xpath = "//span[contains(text() , \"Showing\")]")
    WebElement resultsLabel;



    public demoPo(WebDriver driver) {
        super(driver);
    }


    public void closeLoginDialog() {
       try{
           btnClose.click();
       } catch (NoSuchElementException e) {
           System.out.println("Dialog Box Not Available :" +  e.getMessage());
       }
    }

    public void searchProduct(String product){
        searchBox.sendKeys(product);
        searchBox.submit();
    }

    public void getTotalResult(){
        String totalResults = resultsLabel.getText();
       splitResult(totalResults);

    }

    public void splitResult(String result){
        Pattern pattern = Pattern.compile("of ([\\d,]+) results");
        Matcher matcher = pattern.matcher(result);

       if(matcher.find()){
           System.out.println( matcher.group(1));
       }
       else{
           System.out.println("Error Parsing");
       }

    }


}
