package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlePractice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void window_handling_test(){

    String actualTitle = driver.getTitle();
    String expectedTitle = "Practice";
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement clickHereLink = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereLink.click();
        String titleAfterClick = driver.getTitle();


        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = "+mainHandle);

        Set<String> windowHandles = driver.getWindowHandles();

        for(String each: windowHandles){

            driver.switchTo().window(each);

            System.out.println("Current title while switching: "+driver.getTitle());
        }

        String finalExpectedTitle = "New Window";
        String finalActualTitle = driver.getTitle();

        Assert.assertEquals(finalActualTitle,finalExpectedTitle);
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }



}
