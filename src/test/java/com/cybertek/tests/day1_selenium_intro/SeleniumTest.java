package com.cybertek.tests.day1_selenium_intro;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {
        //1 - set up the web driver
        WebDriverManager.chromedriver().setup();
        //2- create the instance of the chrome driver
        WebDriver driver = new ChromeDriver();

        //3- test if driver is working

        driver.get("https://www.google.com");

        System.out.println("Current title of the page: "+ driver.getTitle());

        String currentUrl = driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);

        //we are using navigate .back method from selenium LIBRARY
        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();

        Thread.sleep(3000);

        driver.navigate().to("https://www.tesla.com");
        //re-assigning value of "current url" String by calling the method again
        currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl: "+currentUrl);

        System.out.println("Current title of the page: " + driver.getTitle());

        driver.manage().window().maximize();

        driver.close();


    }



}
