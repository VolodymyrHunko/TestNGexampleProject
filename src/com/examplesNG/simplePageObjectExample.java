package com.examplesNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.simpleRecipePage;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Volodymyr Hunko
 * Implementation of question 2
 *
 */

public class simplePageObjectExample {
    private static WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        String baseURL = "file:///C://Users//Computer//IdeaProjects//TestNGexampleProject//src//sourseFiles//simpleHTTP.html";
        driver.get(baseURL);
    }

    /**
     * Display the third and fifth item from the above list. Your output should be:
     * Applesauce, unsweetened
     * Juice, Cranberry-apple drink
     */
    @Test (priority=1, enabled = true)
    public void validItems() {
        PageFactory.initElements(driver, simpleRecipePage.class);
        String thirdItem = simpleRecipePage.food_3.getText();
        String fifthItem = simpleRecipePage.food_5.getText();
        System.out.println(thirdItem + "\n" + fifthItem + "\n");
    }

    /**
     * Fetch each food name and its servings and store them in a Map.
     * Iterate through all the entries in the Map and print them.
     */
    @Test (priority=2, enabled = true)
    public void printMap() {
        simpleRecipePage.printRecipe(driver);
    }



    @AfterTest
    public void terminateBrowser(){
        driver.close();
        System.out.println("DONE");
    }
}
