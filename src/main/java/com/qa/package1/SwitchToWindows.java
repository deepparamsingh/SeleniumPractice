package com.qa.package1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class SwitchToWindows extends Testbase {

	Logger log = Logger.getLogger(AssignmentOne.class);

	// PageFactory


	@FindBy(xpath = "//div[@class='orangehrm-login-footer-sm']/a")
	List<WebElement> socialLinks;

	public SwitchToWindows() {
		PageFactory.initElements(driver, this);
	}

	public void verifySocialLinks() throws Throwable {
		int totallinks = socialLinks.size();
		log.info("Total social links are: "+totallinks);
		String parent= driver.getWindowHandle();
		for( WebElement links : socialLinks)
		{
			
			links.click();
					
		}
		 ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		 Thread.sleep(2000);
		 driver.close();
		System.out.println(driver.switchTo().window(newTab.get(3)).getTitle());
		 Thread.sleep(2000);
		 driver.close();
		 System.out.println(driver.switchTo().window(newTab.get(2)).getTitle());
		 Thread.sleep(2000);
		 driver.close();
		 System.out.println(driver.switchTo().window(newTab.get(1)).getTitle());
		 Thread.sleep(2000);
		 driver.close();
		 System.out.println(driver.switchTo().window(newTab.get(4)).getTitle());
		 Thread.sleep(2000);
		 driver.close();
		 System.out.println(driver.switchTo().window(parent).getTitle());
		
	}

}
