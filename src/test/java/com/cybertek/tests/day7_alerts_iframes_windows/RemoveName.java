package com.cybertek.tests.day7_alerts_iframes_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class RemoveName {

    public void removeName(WebDriver driver, String name){
        WebElement delete  = driver.findElement(By.cssSelector("#ctl00_MainContent_btnDelete"));

        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        int nameIndex = 2;
        for(WebElement names: rows){
            if(names.findElement(By.xpath("//table[@class='SampleTable']//tr["+nameIndex+"]//td[2]")).getText().contains(name)){
                names.findElement(By.xpath("//table[@class='SampleTable']//tr["+nameIndex+"]//td[1]")).click();
                delete.click();
                break;
            }
            nameIndex++;
        }
        List<WebElement> list1 = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        list1.forEach(p -> { Assert.assertFalse(p.getText().contains(name));System.out.println(p.getText()); });


    }


}
