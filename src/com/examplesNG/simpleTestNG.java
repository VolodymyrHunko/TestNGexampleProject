package com.examplesNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Volodymyr Hunko
 */

public class simpleTestNG {
    private static WebDriver driver;
    private String baseURL = "http://www.Google.com";

    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(baseURL);
        System.out.println("Before Test completed.");
    }

    @Test (priority=2, enabled = true)
    public void printTitle() {
        System.out.println("Title is: "+driver.getTitle());
    }

    @AfterTest
    public void terminateBrowser(){
        driver.close();
        System.out.println("DONE with After Test");
    }
}
