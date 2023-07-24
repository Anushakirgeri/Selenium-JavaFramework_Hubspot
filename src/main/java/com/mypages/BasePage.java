package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public String getPageHeader(By locator) {
        return getElement(locator).getText();

    }

    @Override
    public WebElement getElement(By locator) {
        WebElement ele = null;
        try {
            ele = driver.findElement(locator);
            return ele;
        } catch (Exception e) {
            System.out.println("Error Occured " +locator.toString());
            e.printStackTrace();
        }
        return ele;
    }

    @Override
    public void waitForElementPresent(By locator) {
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        catch(Exception e){
            System.out.println("Exception occured: " + locator.toString());
        }
    }

    @Override
    public void waitForPageTitle(String title) {
        try{
            wait.until(ExpectedConditions.titleContains(title));
        }catch (Exception e){
            System.out.println("Exception occured:" +title);
        }
    }
}
