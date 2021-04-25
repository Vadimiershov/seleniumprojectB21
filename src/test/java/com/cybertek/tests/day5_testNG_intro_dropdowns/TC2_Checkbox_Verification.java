package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC2_Checkbox_Verification {

    public static void main(String[] args) {

        /*//1. Open Chrome browser

            //2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html

            //3. Verify "Success – Check box is checked" message is NOT displayed.
            //4. Click to checkbox under "Single Checkbox Demo" section
            //5. Verify "Success – Check box is checked" message is displayed.

         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement successMessage = driver.findElement(By.cssSelector("div#txtAge"));

        WebElement checkBox1 = driver.findElement(By.cssSelector("input#isAgeSelected"));

        if(!checkBox1.isSelected() && !successMessage.isDisplayed() ){
            System.out.println("Checkbox is not selected. Message is not displayed. Verification PASS");
        } else {
            System.out.println("Fail!");
        }

        checkBox1.click();

        if(checkBox1.isSelected() && successMessage.isDisplayed() ){
            System.out.println("Checkbox is selected. Message is displayed. Verification PASS");
        } else {
            System.out.println("Fail!");
        }

        driver.close();


















    }



}
