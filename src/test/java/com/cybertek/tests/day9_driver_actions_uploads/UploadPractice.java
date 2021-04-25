package com.cybertek.tests.day9_driver_actions_uploads;

import com.cybertek.utilities.BrowsersUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadPractice {

    @Test
    public void upload_test(){
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        String path = "C:\\Users\\Vadim\\Desktop\\When do you choose automated testing over manual testing.docx";

        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));
        WebElement uploadBtn = Driver.getDriver().findElement(By.id("file-submit"));

        BrowsersUtils.sleep(2);

        chooseFile.sendKeys(path);
        uploadBtn.click();

        WebElement fileUploadedMessage = Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadedMessage.isDisplayed());

        Driver.closeDriver();


    }


}
