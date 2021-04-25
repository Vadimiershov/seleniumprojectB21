package com.cybertek.tests.day8_testbase_properties_driver;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.WebOrderUtils;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebTablePractices extends TestBase {

@Test
    public void verify_order_test() throws IOException {
    Properties properties = new Properties();
    String path = "configuration.properties";
    FileInputStream file = new FileInputStream(path);
    properties.load(file);
    String url = properties.getProperty("webOrderUrl");
    driver.get(url);
    WebOrderUtils.loginToSmartBear(driver);
    WebOrderUtils.verifyOrder(driver,"Mark Smith");



}



}
