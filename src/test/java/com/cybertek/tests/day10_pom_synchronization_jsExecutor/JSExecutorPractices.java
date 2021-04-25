package com.cybertek.tests.day10_pom_synchronization_jsExecutor;

import com.cybertek.utilities.BrowsersUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutorPractices {

    @Test
    public void scroll_using_jsexecutor_test1() {

        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");

        //Create instance of JSExecutor and cast our driver type to it
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        for (int i = 0; i < 10; i++) {
            //Use "js" to reach JavaScriptExecutorMethod
            BrowsersUtils.sleep(1);
            js.executeScript("window.scrollBy(0, 750)");
        }
    }

    @Test
    public void scroll_using_jsexecutor_test2() {
    Driver.getDriver().get("http://practice.cybertekschool.com/large");

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement cybertekSchoolLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
    BrowsersUtils.sleep(2);
    js.executeScript("arguments[0].scrollIntoView(true)", cybertekSchoolLink);
    //This function says: scrollTo first argument (argument[0])
        BrowsersUtils.sleep(2);
        js.executeScript("arguments[0].scrollIntoView(true)",homeLink);

    }
}
