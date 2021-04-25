package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebOrderUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SelfPractice {

WebDriver driver;

@BeforeMethod
    public void setUpDriver(){
    driver = WebDriverFactory.getDriver("chrome");
    driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    driver.manage().window().maximize();
    WebOrderUtils.loginToSmartBear(driver);
}

@Test
public void TC11(){

    //RemoveName removeName = new RemoveName();
    //removeName.removeName(driver,"Mark Smith");

}




}
