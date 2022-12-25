package com.qa.package1;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class AssignmentThree extends Testbase{
	
	Logger log = Logger.getLogger(AssignmentThree.class);
	
	@FindBy(css="ul[class*='oxd-main-menu']>li")
	List <WebElement> allMainTabs;
	
	 String[] array = {"Admin", "PIM","Leave","Time","Recruitment","My Info","Performance",
			 				"Dashboard","Directory","Maintenance","Buzz"};
	List<String> list = Arrays.asList(array);
	    
	
	
	
	
	public  AssignmentThree()
	{
		PageFactory.initElements(driver, this);
	}
	

	
	public boolean verifyTabListwithActual() throws Throwable
	{
	for (int i=0;i<allMainTabs.size();i++)
		{
		String actual= allMainTabs.get(i).getText().trim();
		String existing=list.get(i).trim();
		
		if(!actual.equals(existing))
				{
			log.info("****** "+actual+" not matched with "+existing+" ******");
			return false;
				}
		else {
			log.info(actual+" equals to "+ existing);			
			}
	}
	return true;
}
}
