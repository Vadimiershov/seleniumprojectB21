package com.cybertek.tests.day6_dropdown_review.dropdown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTasks {

    WebDriver driver;



    @BeforeClass
    public void setupMethod(){
         driver = WebDriverFactory.getDriver("chrome");

         driver.get("http://practice.cybertekschool.com/dropdown");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test2_verify_state_dropdown(){

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        stateDropdown.selectByVisibleText("Illinois");

        stateDropdown.selectByValue("VA");

        stateDropdown.selectByIndex(5);

        String expectedOption = "California";

        String actualOption = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption, expectedOption,"Final selected option is not as expected");




    }

    @Test
    public void test3_dropdown_verification(){

        Select yearDropdown = new Select(driver.findElement(By.cssSelector("select#year")));
        Select monthDropdown = new Select(driver.findElement(By.cssSelector("select#month")));
        Select dayDropdown = new Select(driver.findElement(By.cssSelector("select#day")));

        yearDropdown.selectByVisibleText("1922");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);

        String yearExpected = "1922";
        String monthExpected = "December";
        String dayExpected = "1";
        String yearActual = yearDropdown.getFirstSelectedOption().getText();
        String monthActual = monthDropdown.getFirstSelectedOption().getText();
        String dayActual = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertTrue(yearExpected.equals(yearActual),"Actual year is not equal to expected year");
        Assert.assertTrue(monthExpected.equals(monthActual));
        Assert.assertTrue(dayExpected.equals(dayActual));



    }

    @Test
    public void test4_multiple_select_dropdown(){

        Select multipleSelectDropdown = new Select(driver.findElement(By.cssSelector("select[name='Languages']")));

        List<WebElement> allOptions = multipleSelectDropdown.getOptions();

        for(WebElement each:allOptions) {

            each.click();

            System.out.println("Selected: " + each.getText());

            Assert.assertTrue(each.isSelected(), "The option" + each.getText() + " is not selected");

            multipleSelectDropdown.deselectAll();
        }
            for(WebElement each: allOptions){
                Assert.assertFalse(each.isSelected(),"The option" + each.getText()+ "is selected");
            }




    }

@Test
public void test5_non_selected_dropdown() throws InterruptedException {

        WebElement websiteDropdown = driver.findElement(By.cssSelector("a#dropdownMenuLink"));

        Thread.sleep(1000);

        websiteDropdown.click();

        WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));

        facebookLink.click();

        String expectedTitle = "Facebook - Log In or Sign Up";

        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle,"Title is not as expected");


}



    @AfterMethod
    public void tearDownMethod(){


        driver.close();
    }

}
