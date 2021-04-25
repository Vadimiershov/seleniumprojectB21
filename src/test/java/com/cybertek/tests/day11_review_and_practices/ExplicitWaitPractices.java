package com.cybertek.tests.day11_review_and_practices;

import com.cybertek.pages.DynamicLoad1Page;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {

    @Test
    public void dynamic_load_page1(){
        //1.Go tohttp://practice.cybertekschool.com/dynamic_loading/1
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");
        // 2.Click to start
        DynamicLoad1Page dynamicLoad1Page = new DynamicLoad1Page();
        dynamicLoad1Page.startButton.click();
        // 3.Wait until loading bar disappears
        // To be able to wait until loading bar dissapier we will use webdriverWait class
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        //using the object, we will create our expected condition: wait until loading dissapears
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));
        // 4.Assert username inputboxis displayed
        Assert.assertTrue(dynamicLoad1Page.inputUsername.isDisplayed());
        // 5.Enter username: tomsmith
        dynamicLoad1Page.inputUsername.sendKeys("tomsmith");
        // 6.Enter password: incorrectpassword
        dynamicLoad1Page.inputPassword.sendKeys("asdfgh");
        // 7.Click to Submit button
        dynamicLoad1Page.submitButton.click();
        // 8.Assert “Your passwordis invalid!” text is displayed
        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());
    }



}
