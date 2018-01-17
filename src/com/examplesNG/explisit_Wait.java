package com.examplesNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeoutException;

//import org.openqa.selenium.WebElement;

public class explisit_Wait {

    public static void main(String[] args) throws TimeoutException {


        // declaration and instantiation of objects/variables
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://newtours.demoaut.com";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";
/*
        // launch Firefox and direct it to the Base URL
        driver.get(baseUrl);
        // get the actual value of the title
        actualTitle = driver.getTitle();

        //compare the actual title of the page with the expected one and print
        //the result as "Passed" or "Failed"
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Correct page!");
        } else {
            System.out.println("Test Failed");
        }

        // find and get elements commands
        driver.findElement(By.linkText("Home")).click();
        String tag_name = driver.findElement(By.name("userName")).getTagName();
        System.out.println(tag_name);
        String source_code = driver.getPageSource();
        System.out.println(source_code);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String lable = driver.findElement(By.cssSelector("td > font > b")).getText();
        System.out.println(lable);

        //navigate commands
        driver.navigate().refresh(); //refresh current page
        driver.navigate().back();//go back by one page
        driver.navigate().forward();//go forward
        //driver.get("http://www.popuptest.com/popuptest2.html");
        //driver.quit();  // using QUIT all windows will close        //

        //Switch between Frames
        driver.switchTo().frame("classFrame"); //take this frame
        driver.findElement(By.linkText("Deprecated")).click(); //find element on it

        //Switch between POP-UP windows
        String alertMessage = "";
        driver.get("http://jsbin.com/usidix/1");
        driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
        alertMessage = driver.switchTo().alert().getText();//get the text
        driver.switchTo().alert().accept();//close alert
        System.out.println(alertMessage);
        driver.close();
  */
        //Explicit wait until element start visible
        WebDriverWait my_wait_var = new WebDriverWait(driver, 3);
        my_wait_var.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName")));
        driver.findElement(By.name("userName")).sendKeys("tutorial");
        driver.findElement(By.name("userName")).clear();

/*
        //conditions !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        WebElement txt_box_us_name = driver.findElement(By.name("username"));
        try{
        if(txt_box_us_name.isEnabled()){ //or .isDisplayed()
        	txt_box_us_name.sendKeys("tutorial");
        }
        if(driver.findElement(By.id("one-way")).isSelected()){
        	driver.findElement(By.id("two-way")).click();
        }
       if(my_wait_var.until(ExpectedConditions.alertIsPresent()) !=null){
      	System.out.println("alert is present");
        }
        WebElement txt_un = my_wait_var.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        my_wait_var.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("new_frame"));
      }
      catch(NoSuchElementException e){
        System.out.println(e.toString());
      }
  */

        // Select drop-down list
        driver.get("http://newtours.demoaut.com/mercuryregister.php");
        Select dr_box_country = new Select(driver.findElement(By.name("country")));
        dr_box_country.selectByVisibleText("UKRAINE");
        dr_box_country.selectByIndex(1);
        dr_box_country.deselectAll();

        //SUBMIT forms
        driver.findElement(By.name("password")).submit();//instead Click()



        // driver.close();//closes Firefox current page
        driver.quit(); //closes ALL windows
        System.exit(0);// exit the program explicitly
    }

}