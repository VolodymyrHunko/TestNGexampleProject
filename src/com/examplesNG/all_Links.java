package com.examplesNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class all_Links {

    public static void main(String[] args) {
        String baseUrl = "http://nba.com"; //"http://newtours.demoaut.com/";
        WebDriver driver = new ChromeDriver();
        String underConsTitle = "Under Construction: Mercury Tours";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(baseUrl);
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        String[] linkTexts = new String[linkElements.size()];
        int i = 0;

        /*
        validate links by code :
        200 – Valid Link
        404 – Link not found
        400 – Bad request
        401 – Unauthorized
        500 – Internal Error
         */
        for (WebElement w : linkElements) {
            String url = w.getAttribute("href");
            linkTexts[i] = w.getText();
            System.out.println(linkTexts[i] + " = ");
            i++;
            verifyLink(url);
        }

        driver.quit();
    }


    /**
     * The below function verifyLink(String urlLink) verifies any broken links and return the server status
     * by reading the status of each href link with the help of HttpURLConnection class.
     *
     * @param urlLink get the url from mail class
     */
    private static void verifyLink(String urlLink) {
        //Sometimes we may face exception "java.net.MalformedURLException".
        // Keep the code in try catch block to continue the broken link analysis
        try {
            //Use URL Class - Create object of the URL Class and pass the urlLink as parameter
            URL link = new URL(urlLink);
            // Create a connection using URL object (i.e., link)
            HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
            //Set the timeout for 2 seconds
            httpConn.setConnectTimeout(2000);
            //connect using connect method
            httpConn.connect();
            //use getResponseCode() to get the response code.
            if (httpConn.getResponseCode() == 200) {
                System.out.println(urlLink + " - " + httpConn.getResponseMessage());
            }
            if (httpConn.getResponseCode() == 404) {
                System.out.println(urlLink + " - " + httpConn.getResponseMessage());
            }
        }
        //getResponseCode method returns = IOException - if an error occurred connecting to the server.
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
