package com.cybertek.tests.day9_driver_actions_uploads;

import org.testng.annotations.Test;

public class Singleton {

    private Singleton(){
    }

    private static String word;

    public static String getWord(){
        if(word == null){
            System.out.println("First time call. Word object is null");
            word = "something";
        }else {
            System.out.println("Word is already assigned");
        }
        return word;
    }

    @Test
    public void singleton_test1(){
        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);
        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str1);
        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str1);
    }

    @Test
    public void singleton_test2(){
        String str4 = Singleton.getWord();
        System.out.println("str4 = " + str4);
    }

}
