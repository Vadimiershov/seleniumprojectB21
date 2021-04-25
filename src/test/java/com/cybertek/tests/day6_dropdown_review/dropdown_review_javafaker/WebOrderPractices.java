package com.cybertek.tests.day6_dropdown_review.dropdown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebOrderUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebOrderPractices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebOrderUtils.loginToSmartBear(driver);


    }



    @Test
    public void test1_link_verification(){



        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        System.out.println("Number of all links of this page: " + allLinks.size());

        for (WebElement each : allLinks) {

            System.out.println("Each link = "+each.getText());

        }

    }

    @Test
    public void softwareOrderPlacing() throws InterruptedException {

        WebElement orderLink = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderLink.click();

        Select productList = new Select(driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct")));
        productList.selectByIndex(1);

        WebElement productQuantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        Thread.sleep(1000);
        productQuantity.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);
        productQuantity.sendKeys("2");

        WebElement calculateButton = driver.findElement(By.xpath("//input[@type='submit']"));
        calculateButton.click();

        Faker faker = new Faker();

        String fullName = faker.name().fullName();
        String streetName = faker.address().streetName();
        String cityName = faker.address().cityName();
        String stateName = faker.address().state();
        String zipCode = faker.address().zipCode();

        WebElement fullNameBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        WebElement streetNameBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement cityNameBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement stateNameBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zipCodeBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        fullNameBox.sendKeys(fullName);
        streetNameBox.sendKeys(streetName);
        cityNameBox.sendKeys(cityName);
        stateNameBox.sendKeys(stateName);
        zipCodeBox.sendKeys(faker.address().zipCode().replaceAll("-",""));

        WebElement visaRadioButton = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_0"));
        visaRadioButton.click();

        WebElement inputcardNumber = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        inputcardNumber.sendKeys(faker.finance().creditCard().replaceAll("-",""));

        WebElement inputExpireDate= driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        inputExpireDate.sendKeys("05/22");

        WebElement processButton = driver.findElement(By.linkText("Process"));
        processButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));


        Assert.assertTrue(successMessage.isDisplayed(),"Success message is NOT displayed!!!");








    }

    @AfterMethod
    public void tearDownMethod(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //driver.quit();

    }



}
