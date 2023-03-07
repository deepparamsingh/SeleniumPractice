package com.qa.package1;

import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestPractice {

	public static WebDriver driver;

	public static void main(String[] args) throws Throwable {

		//WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		driver = new ChromeDriver(opt);

		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		Thread.sleep(5000);

		WebElement m = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		//String frameName= m.getAttribute("id");
		
		
		WebElement m1 = driver.findElement(By.xpath("//b[normalize-space()='Inner Frame Check box :']"));
		System.out.println(m1.getText());
		
		driver.quit();

	}

}
