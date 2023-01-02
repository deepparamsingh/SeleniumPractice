package com.qa.package1;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPractice {

	public static WebDriver driver;

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		driver = new ChromeDriver(opt);

		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);

		WebElement m = driver.findElement(By.xpath("//div[@class='orangehrm-container']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);

		Thread.sleep(3000);

		driver.quit();

	}

}
