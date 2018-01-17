package com.examplesNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class file_Upload {

    public static void main(String[] args) {

        String baseUrl = "http://www.megafileupload.com/";
        WebDriver driver = new ChromeDriver();

        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.cssSelector("a.slider-btn.slider-btn-upload"));

// enter the file path onto the file-selection input field
        uploadElement.sendKeys("src.sourseFiles.simple.txt");

// click the "UploadFile" button
        driver.findElement(By.xpath("//button[@type='button'][2]")).click();
    }

//



}