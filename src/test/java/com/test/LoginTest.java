package com.test;

import com.mypages.HomePage;
import com.mypages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void verifyLoginPageTitleTest(){
        String title = page.getInstance(LoginPage.class).getLoginPageHeader();
        System.out.println(title);
        //Assert.assertEquals(title, "Hu");
    }

    @Test(priority = 2)
    public void verifyLoginPageHeaderTest(){
       String header = page.getInstance(LoginPage.class).getLoginPageHeader();
        System.out.println(header);
        Assert.assertEquals(header, "Don't have an account?");
    }

    @Test
    public void doLoginTest(){
        HomePage homepage = page.getInstance(LoginPage.class).doLogin("anusha515151@gmail.com", "7$hip@9N");
        String headerHome = String.valueOf(homepage.getHomePageHeader());
        System.out.println(headerHome);
        Assert.assertEquals(headerHome, "Getting started with Hubspot!");

    }
}
