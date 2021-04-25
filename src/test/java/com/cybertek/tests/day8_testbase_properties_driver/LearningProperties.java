package com.cybertek.tests.day8_testbase_properties_driver;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LearningProperties {

    @Test
    public void java_properties_reading_test() throws IOException {

        //1. Create Properties class object
        Properties properties = new Properties();

        //2. Open the file iin JVM Memory and pass the path of the file
        String path = "configuration.properties"; //copy path from content root

        FileInputStream file = new FileInputStream(path);

        //3. Load the opened file into the Properties object
        properties.load(file);

        //read some values from the file
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));

        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));


    }



}
