package com.qa.package1;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class AssignmentTwo extends Testbase {
	
	Logger log = Logger.getLogger(AssignmentTwo.class);
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement userName;
	
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	
	@FindBy(xpath="//div[@class='oxd-alert-content oxd-alert-content--error']/p")
	WebElement invalidCred;
	
				
	
	public AssignmentTwo()
	{
		PageFactory.initElements(driver, this);
	}

	
		
	public boolean UNcssProperties()
	{
		String UNcssProp= userName.getCssValue("border");	
		String[] splited = UNcssProp.split("\\s+");
		log.info("value at first index is :"+splited[0]);
		if(splited[0].equalsIgnoreCase("1px"))
			{
			log.info("Border value is 1px");
			return true;
			}
		return false;
	}
	
	public void enterUserName(String useName)
	{
		sendKeys(driver, userName, Duration.ofSeconds(3), useName);
	}
	

	public void enterPassword(String pass)
	{
		sendKeys(driver, password, Duration.ofSeconds(3), pass);	
	}
	
	public boolean verifyInvalidAlert()
	{
		
		Helper.waitForElementToBeVisible(driver, invalidCred, Duration.ofSeconds(5000));
		if(invalidCred.isDisplayed())
		{
			String invalidCredMSG=invalidCred.getText();
			if(invalidCredMSG.equals("Invalid credentials"))
			{
				log.info("User credentials are not Valid: "+ invalidCredMSG);
				return true;
			}
			
			
		}
		return false;
	}

}
