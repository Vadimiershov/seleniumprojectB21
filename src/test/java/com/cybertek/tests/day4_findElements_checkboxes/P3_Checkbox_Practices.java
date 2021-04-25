package com.cybertek.tests.day4_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P3_Checkbox_Practices {

    public static void main(String[] args) throws InterruptedException {

        //Practice: Cybertek Checkboxes
        //1. Go to http://practice.cybertekschool.com/checkboxes
        //2. Confirm checkbox #1 is NOT selected by default
        //3. Confirm checkbox #2 is SELECTED by default.
        //4. Click checkbox #1 to select it.
        //5. Click checkbox #2 to deselect it.
        //6. Confirm checkbox #1 is SELECTED.
        //7. Confirm checkbox #2 is NOT selected.

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/checkboxes ");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement checkbox1  = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2  = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        if(!checkbox1.isSelected()){
            System.out.println("Checkbox#1 is not selected. Default value verification Passed!");
        }else{
            System.out.println("Checkbox#1 is selected. Default value verification Failed!");
        }

        if(checkbox2.isSelected()){
            System.out.println("Checkbox#2 is selected. Default value verification Passed!");
        }else{
            System.out.println("Checkbox#2 is not selected. Default value verification Failed!");
        }
        Thread.sleep(2000);
        checkbox1.click();

        Thread.sleep(2000);
        checkbox2.click();

        if(checkbox1.isSelected()){
            System.out.println("Checkbox#1 is selected. Default value verification Passed!");
        }else{
            System.out.println("Checkbox#1 is not selected. Default value verification Failed!");
        }

        if(!checkbox2.isSelected()){
            System.out.println("Checkbox#2 is not selected. Verification Passed!");
        }else{
            System.out.println("Checkbox#2 is selected. Verification Failed!");
        }

        driver.close();

    }



}
