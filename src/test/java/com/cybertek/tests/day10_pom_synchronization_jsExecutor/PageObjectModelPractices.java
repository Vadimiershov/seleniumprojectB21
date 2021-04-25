package com.cybertek.tests.day10_pom_synchronization_jsExecutor;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

public class PageObjectModelPractices {

    @Test
    public void login_to_smartBear(){
        String url = ConfigurationReader.getProperty("webOrderUrl");
        Driver.getDriver().get(url);
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("usernameSmartBear");
        String password = ConfigurationReader.getProperty("passwordSmartBear");
        loginPage.inputUserName.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
        loginPage.loginButton.click();
    }


}
