package com.cybertek.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WT_CybertekLinkVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        driver.findElement(By.name("email")).sendKeys("anything@anydomain.com");

        driver.findElement(By.id("form_submit")).click();

        String expectedInUrl = "email_sent";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedInUrl)){
            System.out.println("URL verification passed");
        }else{
            System.out.println("URL verification failed");
            System.out.println("actual URL "+ actualUrl);
            System.out.println("expected URL "+ expectedInUrl);
        }

        WebElement confirmation_message = driver.findElement(By.name("confirmation_message"));

        if(confirmation_message.isDisplayed()){
            System.out.println("Confirmation message is displayed. PASS!!!");
        }else{
            System.out.println("Conirmation message is not displayed. FAIL!!!!");
        }

        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage  = driver.findElement(By.name("confirmation_message")).getText();
        String actualMessage2 = confirmation_message.getText();

        if(actualMessage.equals(expectedMessage)){
            System.out.println("Message verification PASSED");
        }else{
            System.out.println("Message verification FAILED");

        }




    }



}
