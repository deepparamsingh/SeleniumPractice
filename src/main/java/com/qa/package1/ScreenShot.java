package com.qa.package1;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class ScreenShot extends Testbase {

	Logger log = Logger.getLogger(AssignmentFour.class);

	@FindBy(xpath = "//input[@title='Sign in']")
	WebElement signInBtn;

	public ScreenShot() {
		PageFactory.initElements(driver, this);
	}

	public void VerifyScreenShot() throws Throwable {
		signInBtn.click();
		Helper.takeScreenShotWithAlert();

	}

}
