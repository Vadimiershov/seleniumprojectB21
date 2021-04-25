package com.cybertek.tests.day8_testbase_properties_driver;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ReadingFromProperties {
    @Test
    public void reading_from_properties_files(){

    }

    @Test
    public void using_properties_util_method(){
        System.out.println("ConfigurationReader.getProperty(\"browser\") = " + ConfigurationReader.getProperty("browser"));
        System.out.println("ConfigurationReader.getProperty(\"webOrderUrl\") = " + ConfigurationReader.getProperty("webOrderUrl"));

    }


}
