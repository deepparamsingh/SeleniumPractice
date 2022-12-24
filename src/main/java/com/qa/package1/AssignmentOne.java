package com.qa.package1;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class AssignmentOne extends Testbase {
	
	
	
			//PageFactory
	
			@FindBy(xpath = "//img[@alt='company-branding']")
			WebElement siteLOGO;
			
			@FindBy(xpath="//div[@class='orangehrm-login-footer-sm']/a")
			List <WebElement> socialLinks;
			
						
			
			public AssignmentOne()
			{
				PageFactory.initElements(driver, this);
			}
			
	
	public boolean verifySiteLogo() throws Throwable
	{
		waitForElementToBeVisible(driver, siteLOGO, Duration.ofSeconds(10));
		if(siteLOGO.isDisplayed())
		{
			return true;
		}
		return false;
		
	}
	
	public int verifySocialLinks() throws Throwable
	{
		
		int totallinks = socialLinks.size();
		System.out.println("Total social links are: "+totallinks);
		for( WebElement links : socialLinks)
		{
			System.out.println(links.getAttribute("href"));
		}
		return totallinks;
		
	}
	
	public boolean verifyYTlinkExist()
	{
		
		boolean result = false;
			int totallinks = socialLinks.size();
			System.out.println("Total social links are: "+totallinks);
			for( WebElement links : socialLinks)
			{
				
				String link= links.getAttribute("href");
				if(link.contains("youtube"))
				{
					System.out.println("YouTube Link Found !!!  "+link);
					result = true;
					break;
				}
			
			}
			return result;			
			
	}
	
	public void verifySocialLinksWithMAP()
	{
		HashMap<String, String> capitalCities = new HashMap<String,String>();
		 String a[] = new String[] { "Linkedin", "Facebook", "Twitter", "YouTube" };
		
		 int i =0;
		for( WebElement links : socialLinks)
		{
			    
				String link= links.getAttribute("href");
			    capitalCities.put(a[i], link);
			    i++;
			    
		}
		System.out.println(capitalCities);
		
	}

	

}
