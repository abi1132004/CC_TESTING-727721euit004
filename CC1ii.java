package com.selenium.test2.selenium1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CC1ii {
	public static void main(String[] args) throws InterruptedException {
				WebDriverManager.chromedriver().setup();
		    	ChromeOptions co=new ChromeOptions();
		    	co.addArguments("--remote-allow-origins=*");
				WebDriver driver=new ChromeDriver(co);
		    	driver.get("https://www.saucedemo.com/");
		    	driver.manage().window().maximize();
		    	WebElement sel=driver.findElement(By.id("user-name"));
		    	sel.sendKeys("standard_user");
		    	WebElement sel2=driver.findElement(By.id("password"));
		    	sel2.sendKeys("secret_sauce");
		    	WebElement sel3=driver.findElement(By.id("login-button"));
		    	Thread.sleep(4000);
		    	sel3.click();
		    	WebElement sort1=driver.findElement(By.className("product_sort_container"));
		    	sort1.click();
		    	Select select= new Select(sort1);
		    	select.selectByVisibleText("Name (A to Z)");
		    	Thread.sleep(4000);
		    	WebElement iden=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]"));
		    	if(iden.getText().equals("Name (A to Z)")) {
		    		System.out.println("1.Verified that the user is able to apply the filter Name (A to Z)");
		    	}
		    	Thread.sleep(4000);
		    	iden.click();
		    	WebElement name=driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
		    	System.out.println("First product name while filtering from A-Z :-"+name.getText());
		    	
		    	WebElement iden1=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]"));
		    	if(iden1.getText().equals("Name (Z to A)")) {
		    		System.out.println("2.Verified that the user is able to apply the filter Name (Z to A)");
		    	}    	
		    	iden1.click();
		    	Thread.sleep(4000);
		    	WebElement name1=driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div"));
		    	System.out.println("First product name while filtering from Z-A :-"+name1.getText());
		    	
		    	WebElement iden2=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]"));
		    	if(iden2.getText().equals("Price (low to high)")) {
		    		System.out.println("3.Verified that the user is able to apply the filter Price (low to high)");
		    	}    	
		    	iden2.click();
		    	Thread.sleep(4000);
		    	WebElement name2=driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div"));
		    	System.out.println("First product name while filtering from Price (low to high) :-"+name2.getText());
		    	
		    	WebElement iden3=driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]"));
		    	if(iden3.getText().equals("Price (high to low)")) {
		    		System.out.println("4.Verified that the user is able to apply the filter Price (high to low)");
		    	}    	
		    	iden3.click();
		    	Thread.sleep(4000);
		    	WebElement name3=driver.findElement(By.xpath("//*[@id=\"item_5_title_link\"]/div"));
		    	System.out.println("First product name while filtering from Price (high to low) :-"+name3.getText());
	}
}
