package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_FacebookTitleVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        String actualFacebookLandingPage = driver.getTitle();

        String expectedFacebookLandingPage = "Facebook - Log In or Sign Up";

        if(actualFacebookLandingPage.equals(expectedFacebookLandingPage)) {
            System.out.println("Landing Facebook page title test PASS!");
        }else {
            System.err.println("Landing Facebook page title test Failed!!!");
            System.out.println("actualFacebookLandingPage = " + actualFacebookLandingPage);
            System.out.println("expectedFacebookLandingPage = " + expectedFacebookLandingPage);
        }
        driver.close();


    }



}
