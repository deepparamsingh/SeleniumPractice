package com.qa.package1;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinks{
	
	public static WebDriver driver;

	public static void main(String[] args) throws Throwable {
		
		//WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
		driver = new ChromeDriver(opt);

		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No of links are " + links.size());

		List<String> urlList = new ArrayList<String>();

		for (WebElement e : links) {
			String url = e.getAttribute("href");
			urlList.add(url);
		}


		long srTime = System.currentTimeMillis();
		urlList.parallelStream().forEach(e -> checkBrokenLink(e));
		long endTime = System.currentTimeMillis();

		System.out.println("Total time taken :" + (endTime - srTime));

		driver.quit();

	}

	public static void checkBrokenLink(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
			httpsURLConnection.setConnectTimeout(5000);
			httpsURLConnection.connect();

			if (httpsURLConnection.getResponseCode() >= 400) {
				System.out.println(linkUrl + " ----> " + httpsURLConnection.getResponseMessage() + " is broken link");
			} else {
				System.out.println(linkUrl + " ----> " + httpsURLConnection.getResponseMessage());
			}
		} catch (Exception e) {
			
		}
	}

	
	
	
}
