package com.cybertek.tests.day4_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PO_FindElements_Practice1 {

    public static void main(String[] args) {

        //#1- Open chrome browser and go to: http://practice.cybertekschool.com/forgot_password
        //#2- Locate all of the LINKS on the page, and print out all the texts
        //#3- Print out how many links on the page

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        driver.manage().window().maximize();

        List<WebElement>listOfLinks = driver.findElements(By.xpath("//body//a"));

        for(WebElement eachLink: listOfLinks){

            System.out.println(eachLink.getText());
        }

        int numberOfLinks = listOfLinks.size();

        System.out.println(numberOfLinks);

        driver.close();
    }



}
