package com.cybertek.tests.day5_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Introduction {

    @BeforeMethod
    public void setupMethod(){
        System.out.println("Before method is running...");
    }

    @BeforeClass
    public void setupClass(){
        System.out.println("Before class is running...");
    }

    @AfterClass
    public void teardownClass(){
        System.out.println("After class is running...");
    }

    @Test
    public void test1(){
        System.out.println("Running test 1...");
    }

    @Test
    public void test2(){
        System.out.println("Running test 2...");
    }

    @Test
    public void test3(){
        System.out.println("Running test 3...");

        String str1 = "hello";
        String str2 = "hello";
        String str3 = "asfsdfgdsg";

        Assert.assertTrue(str1.equals(str2),"Self notes for ourselves");

        Assert.assertEquals(str1,str3,"Asserting with assertEquals on line 56");




    }



}
