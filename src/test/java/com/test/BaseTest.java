package com.test;

import com.mypages.BasePage;
import com.mypages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    WebDriver driver;
    public Page page;

    @BeforeMethod
    @Parameters(value={"browser"})
    public void setupTest(String browser) throws InterruptedException {
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(browser.equals("ff")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else{
            System.out.println("No Browser defined in the xml");
        }
        driver.get("https://app.hubspot.com/login");
        Thread.sleep(6000);
        page = new BasePage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
