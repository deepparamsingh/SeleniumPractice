package com.qa.package1;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.Testbase;

public class Helper extends Testbase {

	Logger log = Logger.getLogger(Helper.class);

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//li[@class='oxd-userdropdown']")
	WebElement userImg;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logOut;

	@FindBy(css = "*[class*='oxd-input-field-error-message']")
	WebElement inputFieldsValidation;

	

	public Helper() {
		PageFactory.initElements(driver, this);
	}

	public String captureURL() {
		return driver.getCurrentUrl();
	}

	public boolean isCurrentURLcontains(String word) {
		if (captureURL().contains(word)) {
			log.info("Current URL contains :" + word);
			return true;
		}
		return false;
	}

	public boolean URLEndsWith(String word) {
		if (captureURL().endsWith(word)) {
			return true;
		}
		return false;
	}

	public String captureURLTitle() {
		return driver.getTitle();
	}

	public boolean verifyTitleContains(String word) {

		if (captureURLTitle().contains(word)) {
			return true;
		}
		return false;
	}

	public void clickLoginBTN() {
		waitForElementToBeVisible(driver, loginButton, Duration.ofSeconds(3));
		clickOn(driver, loginButton, Duration.ofSeconds(5));
	}

	public boolean verifyEmptyLoginvalidation() throws Throwable {

		waitForElementToBeVisible(driver, inputFieldsValidation, Duration.ofSeconds(3));
		String validationMsg = inputFieldsValidation.getText();
		boolean value = validationMsg.equals("Required");
		return value;
	}

	public boolean userImage() {
		waitForElementToBeVisible(driver, userImg, Duration.ofSeconds(5));
		if (userImg.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void clickYourProfileImg() {
		userImg.click();
	}

	public void logOut() {
		logOut.click();
	}

	public void clickTab(String tab) throws Throwable {
		WebElement selectTab = driver.findElement(By.xpath("//span[normalize-space()='" + tab + "']"));
		waitForElementToBeVisible(driver, selectTab, Duration.ofSeconds(5));
		selectTab.click();
		// Thread.sleep(5000);
	}

}
