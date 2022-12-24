package com.qa.package1;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPractice {
	
	public static WebDriver driver;

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		 // TODO Auto-generated method stub
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking","enable-automation")); 
			driver= new ChromeDriver(opt);
			
			  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			  Thread.sleep(6000);
			  
			
			  
			  driver.findElement(By.xpath("//button[@type='submit']")).click();
			  
			  if(driver.findElement(By.xpath("//div[@class='orangehrm-login-logo']//img[@alt='orangehrm-logo']"))
					  .isDisplayed())
			  {
				  System.out.println("Logo is visible");
			  }
			  

			  if(driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']//img[@alt='company-branding']"))
					  .isDisplayed())
			  {
				  System.out.println(" TOP Logo is visible");
			  }
			  
			
			  
			
			  
			  Thread.sleep(3000);
			  
			
			  driver.quit();

	}

}
