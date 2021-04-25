package com.cybertek.utilities;

public class BrowsersUtils {

    public static void sleep(int second){
        second *=1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){
            System.out.println("something happen in sleep method");
        }
    }



}
