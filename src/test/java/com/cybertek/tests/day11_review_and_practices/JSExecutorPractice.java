package com.cybertek.tests.day11_review_and_practices;

import com.cybertek.pages.SignUpPage;
import com.cybertek.utilities.BrowsersUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JSExecutorPractice {

    @Test
    public void fill_form_using_jsexecutor(){

        Driver.getDriver().get("http://practice.cybertekschool.com/sign_up");
        //Create instance of JSExecutor and cast our Webdriver type to it
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //Creating the object to be able to use WebElements from it
        SignUpPage signUpPage = new SignUpPage();
        //Use .setAttribute function from JavaScript to SendKeys
        BrowsersUtils.sleep(1);
        js.executeScript("arguments[0].setAttribute('value', 'jane doe')",signUpPage.inputFullName);
        BrowsersUtils.sleep(1);
        js.executeScript("arguments[0].setAttribute('value', 'something@email.com')",signUpPage.inputEmail);
        BrowsersUtils.sleep(1);
        js.executeScript("arguments[0].click();",signUpPage.signUpButton);

    }

    @Test
    public void opening_tabs_using_jsExecutor(){
        Driver.getDriver().get("https://www.amazon.com");
        //Downcasting our driver type directly in one line
        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('https://google.com','_blank')");
    }



}
