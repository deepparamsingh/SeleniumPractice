package com.qa.package1;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.Testbase;

public class AssignmentFour extends Testbase {
	
	
	Logger log = Logger.getLogger(AssignmentFour.class);
	
	@FindBy(xpath="//h2[contains(text(),'Facebook helps you connect and share with the people in your life.')]")
	WebElement H2text;
	
	@FindBy(css="ul[class*='pageFooterLinkList']>li")
	List <WebElement> footerLinks;
	
	@FindBy(css="a[id^='u_0_']") 
	WebElement createNewAccount;
	 
	@FindBy(xpath="//input[@name='firstname']")
	WebElement firstNameInput;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lastNameInput;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	WebElement emailInput;
	
	@FindBy(xpath="//input[@name='reg_email_confirmation__']")
	WebElement re_emailInput;
	
	@FindBy(xpath="//input[@name='reg_passwd__']")
	WebElement passwordInput;
	
	@FindBy(xpath="//select[@id='day']")
	WebElement day;
	
	@FindBy(xpath="//select[@id='month']")
	WebElement month;
	
	@FindBy(xpath="//select[@id='year']")
	WebElement year;
	
	@FindBy(xpath="//label[normalize-space()='Male']")
	WebElement maleRadio;
		
	@FindBy(xpath="//button[@type='submit' and @name='websubmit']")
	WebElement signUpbtn;
	
	
	public  AssignmentFour()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyH2text()
	{
		String text = H2text.getText();
		if(text.contains("Facebook helps you connect and share with the people in your life."))
		{
			return true;
		}
		return false;
	}
	
	public void verifyFooterAndClickPage(String word) throws Throwable
	{
		for(WebElement footerLnk : footerLinks)
		{
			String footerLnkValue= footerLnk.getText();
			if(footerLnkValue.equalsIgnoreCase(word))
			{
				log.info(word+" link found!!");
				footerLnk.click();
				break;
			}
		}
	}
	
	public void signUpnewUser() throws Throwable
	{
		createNewAccount.click();
		sendKeys(driver, firstNameInput, Duration.ofSeconds(5), "deep");
		sendKeys(driver, lastNameInput, Duration.ofSeconds(5), "param");
		sendKeys(driver, emailInput, Duration.ofSeconds(5), "deepparamsingh@gmail.com");
		sendKeys(driver, re_emailInput, Duration.ofSeconds(5), "deepparamsingh@gmail.com");
		sendKeys(driver, passwordInput, Duration.ofSeconds(5), "xyz123");
		Select selectDay = new Select(day);
		Select selectMonth = new Select(month);
		Select selectYear = new Select(year);
		selectDay.selectByValue("25");
		selectMonth.selectByVisibleText("Apr");
		selectYear.selectByValue("1995");
		maleRadio.click();
		signUpbtn.click();
		
		Thread.sleep(5000);
				
	}
	

}
