package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class WebOrderUtils {

    public static void loginToSmartBear(WebDriver driver){

        //make the order static we don't have to create instance of the class

        WebElement inputUserName = driver.findElement(By.id("ctl00_MainContent_username"));
        inputUserName.sendKeys("Tester");

        WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));
        inputPassword.sendKeys("test");

        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();
    }

    public static void verifyOrder(WebDriver driver,String expectedName){

        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));

        for (WebElement each : allNames) {
            if(each.getText().equals(expectedName)){
                Assert.assertEquals(expectedName, each.getText());
                return;
            }
        }
        Assert.fail("The expectedName is not in the table. ");//will fail the test no matter what



    }


}
