package com.examplesNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class amazonTask
{

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver drive = new ChromeDriver();
        drive.get("https://www.amazon.com/ref=nav_logo");
        String title = drive.getTitle();
        System.out.println(title);
        //Type name of book
        drive.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
        // Click the search
        drive.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")).click();
        Thread.sleep(300);
        //Click 'Books'
        drive.findElement(By.xpath("//li[@id='result_2']/div/div/div/div[2]/div[2]/a/h2")).click();
        Thread.sleep(500);
        // Get amount of items in cart
        String cart = drive.findElement(By.cssSelector("#nav-cart-count")).getText();
        System.out.println("In cart is(are): " + cart + "item(s).");
        int cart_int = Integer.parseInt(cart);
        title = drive.getTitle();
        System.out.println(title);
        // Get the price of book
        String pr_st = drive.findElement(By.xpath("//div[@id='buyNewSection']/a/h5/div/div[2]/div/span[2]")).getText();
        String price_string = pr_st.replace("$","");
        double price = Double.parseDouble(price_string);
        System.out.println(price);
        //Select 3 books
        drive.findElement(By.xpath(".//*[@id='quantity']")).sendKeys("3");
        Thread.sleep(100);
        //Get new cart
        drive.findElement(By.xpath(".//*[@id='add-to-cart-button']")).click();
        cart = drive.findElement(By.cssSelector("#nav-cart-count")).getText();
        cart_int = Integer.parseInt(cart);
        // Get total cost
        String subtotal = drive.findElement(By.xpath("//div[@id='hlb-subcart']/div/span/span[2]")).getText().replace("$", "");
        double sub_dob = Double.parseDouble(subtotal);
        //compare subtotal
        if(cart_int*price == sub_dob)
            System.out.println("Subtotal is: " + subtotal + " for " + cart_int + " items.");
        else System.out.println("Error");
        drive.close();

        // exit the program explicitly
        System.exit(0);
    }
}
