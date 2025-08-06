package com.flipkart.framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.flipkart.framework.init.WebDriverInit.driver;

public class WaitUtils {

    public static WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));

    public void implicitlyWaitOf(int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public static void waitForVisibility(WebElement element){
         wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForInvisibility(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public WebElement advanceWaitForElement(By Locator){
        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        return wait.until(driver -> driver.findElement(Locator));
    }
}


