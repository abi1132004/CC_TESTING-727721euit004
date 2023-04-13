package com.selenium.test2.selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CC1i {
	public static void main(String[] args){
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		//driver.get("https://www.amazon.in/dp/B0BXPHJN21/ref=syn_sd_onsite_desktop_0?ie=UTF8&pd_rd_plhdr=t&th=1");
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		WebElement logbtn = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		logbtn.click();
		WebElement add=driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
		add.click();
		String added=driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).getText();
		if(added.equals("Remove")){
			System.out.println("Added this item");
	    }
		else {
			System.out.println("Item is not added");
		}
		WebElement cart=driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
		cart.click();
		String cartcheck=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		if(cartcheck.equals("Your Cart")) {
			System.out.println("Your cart is viewed");
		}
		WebElement checked=driver.findElement(By.xpath("//*[@id=\"checkout\"]"));
		checked.click();
		WebElement firstname = driver.findElement(By.id("first-name"));
		WebElement lastname = driver.findElement(By.id("last-name"));
		WebElement pincode = driver.findElement(By.id("postal-code"));
		firstname.sendKeys("ABISHEK");
		lastname.sendKeys("K S");
		pincode.sendKeys("641006");
		WebElement fillbtn=driver.findElement(By.xpath("//*[@id=\"continue\"]"));
		fillbtn.click();
		String formFilled = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
		 if(formFilled.equals("Checkout: Overview")) {
			 System.out.println("Product overview is displayed");
		 }else {
			 System.out.println("Product overview is not displayed");
		 }
		 String name = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
		 String price = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
		 System.out.println("Name  : " + name);
		 System.out.println("Price : " + price);
		 String title = driver.getTitle();
		 if(title.equals("Swag Labs")) {
			 System.out.println("Asserted the title of the page");
		 }else {
			 System.out.println("The title of the page is not matching");
		 }
		 String url = driver.getCurrentUrl();
		 if(url.equals("https://www.saucedemo.com/checkout-step-two.html")) {
			 System.out.println("Asserted the URL of the page");
		 }else {
			 System.out.println("The URL of the page is not matching");
		 }
	}
}
