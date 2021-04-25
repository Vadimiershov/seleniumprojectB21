package com.cybertek.tests.day4_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P2_MerriamWebster_Practice {

    public static void main(String[] args) {

        //1. Open Chrome browser
        //2. Go to https://www.merriam-webster.com/
        //3. Print out the texts of all links
        //4. Print out how many link is missing text
        //5. Print out how many link has text
        //6. Print out how many total link

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.merriam-webster.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        List<WebElement>allLinks = driver.findElements(By.xpath("//body//a"));

        int linksWithText = 0;
        int linksWithoutText = 0;

        for(WebElement eachLink: allLinks){

            String textOfEachLink = eachLink.getText();



            if(textOfEachLink.isEmpty()){
                linksWithoutText++;
            }else {
                linksWithText++;
            }

        }

        int linkCount = allLinks.size();

        System.out.println("link without text = "+linksWithoutText);

        System.out.println("link with text = "+linksWithText);

        System.out.println(linkCount);

    }



}
