package com.smoke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseLogin {
	
	public static void main(String[] args) throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();//upcasting polymorphism
		
		  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.zoopla.co.uk/");
		
		WebElement cookie= driver.findElement(By.xpath("//*[@id=\"cookie-consent-form\"]/div/div/div/button[2]"));
		cookie.click();
		WebElement signin = driver.findElement(By.xpath("//*[@id=\"main-nav\"]/ul[1]/li[3]/a"));
		signin.click();
		WebElement email = driver.findElement(By.xpath("//*[@type='email']"));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');", email);
		email.sendKeys("anjumsharaf@gmail.com");
		WebElement pass= driver.findElement(By.xpath("//*[@id=\"signin_password\"]"));
		JavascriptExecutor bs = ((JavascriptExecutor)driver);
		bs.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid red;');", pass);
		pass.sendKeys("@allahuakbar1");
		String title=driver.getTitle();
		String expectedtitle = "Register or sign in to Zoopla - Zoopla";
		if (title.equalsIgnoreCase(expectedtitle)) {
			System.out.println("passed");
		}
		else {
			System.out.println("faled");
		}
		
		driver.close();
		driver.quit();
		
	}

	



}
