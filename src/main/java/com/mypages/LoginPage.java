package com.mypages;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
//page locators:
    private By emailId = By.id("username");
    private By password = By.id("password");
    private By login = By.id("loginBtn");
    private By header = By.id("//i18n-string[@data-key='login.signupLink.text']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //public getters

    public WebElement getEmailId() {
        return getElement(emailId);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getLogin() {
        return getElement(login);
    }

    public WebElement getHeader() {
        return getElement(header);
    }

    public String LoginPageTitle(){
      return getPageTitle();
    }

    /**
     *
     */
    public String getLoginPageHeader(){
       return getPageHeader(header);
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public HomePage doLogin(String username, String password){
        getEmailId().sendKeys(username);
        getPassword().sendKeys(password);
        getLogin().click();
        return getInstance(HomePage.class);
    }
}
