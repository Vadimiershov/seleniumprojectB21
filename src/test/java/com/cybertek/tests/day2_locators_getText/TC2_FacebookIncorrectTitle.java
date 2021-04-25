package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_FacebookIncorrectTitle {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        driver.findElement(By.id("email")).sendKeys("asdfghkj@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123vfghr" + Keys.ENTER);


        String expectedIncorrectTitle = driver.getTitle();
        String actualIncorrectTitle = "Log into Facebook | Facebook";

        if(expectedIncorrectTitle.equals(actualIncorrectTitle))
            System.out.println("Login Title verification Test Pass!!!");
        else
            System.out.println("Login Title verification Test Fail!!!");
        System.out.println("expectedIncorrectTitle = " + expectedIncorrectTitle);
        System.out.println("actualIncorrectTitle = " + actualIncorrectTitle);

        driver.close();



    }



}
