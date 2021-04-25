package com.cybertek.tests.day4_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_Xpath_CssSelector {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement homeLink = driver.findElement(By.xpath("//a[.='Home']"));

        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        WebElement emailLabel = driver.findElement(By.xpath("//label[.='E-mail']"));

        WebElement emailInputBox = driver.findElement(By.xpath("//input[@name='email']"));

        WebElement retrievePassword = driver.findElement(By.xpath("//i[contains(@class,'icon')]"));

        WebElement footerText = driver.findElement(By.xpath("//div[@style=\"text-align: center;\"]"));

        if(homeLink.isDisplayed() && forgotPasswordHeader.isDisplayed() && emailInputBox.isDisplayed()
        && emailLabel.isDisplayed()&& retrievePassword.isDisplayed() && footerText.isDisplayed()){
            System.out.println("ALL WEB ELEMENTS ARE DISPLAYED. VERIFICATION PASSED");
        }else {
            System.out.println("One or more of the web elements are not displayed. Verification FAILED!!!");
        }

        driver.close();



    }


}
