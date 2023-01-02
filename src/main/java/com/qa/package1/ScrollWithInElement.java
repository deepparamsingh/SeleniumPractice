package com.qa.package1;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.base.Testbase;

public class ScrollWithInElement extends Testbase {

	Logger log = Logger.getLogger(AssignmentOne.class);

	// PageFactory

	@FindBy(xpath = "//div[@class='orangehrm-container']")
	WebElement scrollElement;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions action = new Actions(driver);

	public ScrollWithInElement() {
		PageFactory.initElements(driver, this);
	}

	public void scrollInside() throws Throwable {
		
		
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(3000);
		action.scrollToElement(scrollElement);
		//EventFiringWebDriver e = new EventFiringWebDriver(driver;)
		
		Thread.sleep(3000);
	

	}

	

}
