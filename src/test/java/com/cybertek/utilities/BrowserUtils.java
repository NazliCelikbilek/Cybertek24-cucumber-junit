package com.cybertek.utilities;

import org.openqa.selenium.JavascriptExecutor;

public class BrowserUtils {
    /**
     * this method is used to pause the code fr given seconds.
     * it is static method so we can call:
     * BrowswUtils.sleep(5)
     * @param seconds
     */
    public static void sleep (int seconds){
    try {
        Thread.sleep(seconds * 1000);
    }catch (InterruptedException e){
        e.printStackTrace();
        System.out.println("Expectation happened in sleep method");
    }
    }
    public static void scrollDown(int pixels) {
        JavascriptExecutor js =(JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,"+pixels+")");
    }
}
