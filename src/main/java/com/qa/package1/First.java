package com.qa.package1;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Testbase;

public class First extends Testbase {

	Logger log = Logger.getLogger(First.class);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//span[@class='navbar-toggler-icon']")
	WebElement navBar;

	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement loginBTN;

	@FindBy(xpath = "//button[normalize-space()='Sign out']")
	WebElement signOutBTN;

	@FindBy(xpath = "//button[@aria-label='Close']")
	WebElement crossNavBar;

	@FindBy(xpath = "//input[@id='email1']")
	WebElement emailInput;

	@FindBy(xpath = "//input[@id='password1']")
	WebElement passwordInput;

	@FindBy(xpath = "//button[normalize-space()='Sign in']")
	WebElement signInBTN;

	@FindBy(xpath = "//h1[normalize-space()='Learn Automation Courses']")
	WebElement h1Heading;

	@FindBy(xpath = "//h4[@class='welcomeMessage']")
	WebElement welcomeMsg;

	@FindBy(xpath = "//span[normalize-space()='Manage']")
	WebElement manageTab;

	@FindBy(xpath = "//a[normalize-space()='Manage Courses']")
	WebElement manageCourses;

	@FindBy(xpath = "//button[normalize-space()='Add New Course']")
	WebElement addCourse;

	@FindBy(xpath = "//input[@id='thumbnail']")
	WebElement selectThumbnail;

	@FindBy(xpath = "//input[@id='name']")
	WebElement courseName;

	@FindBy(xpath = "//textarea[@id='description']")
	WebElement courseDesciption;

	@FindBy(xpath = "//input[@id='instructorNameId']")
	WebElement instructorName;

	@FindBy(xpath = "//input[@id='price']")
	WebElement coursePrice;

	@FindBy(xpath = "//input[@name='startDate']")
	WebElement startDateField;

	@FindBy(css = "div[class*='__day--005']")
	WebElement startDate;

	@FindBy(xpath = "//div[@class='react-datepicker__current-month']")
	WebElement currentMonthAndYear;

	@FindBy(xpath = "//button[@aria-label='Next Month']")
	WebElement nextMonth;

	@FindBy(xpath = "//button[@aria-label='Previous Month']")
	WebElement previousMonth;

	@FindBy(xpath = "//input[@name='endDate']")
	WebElement endDateField;

	@FindBy(css = "div[class*='__day--005']")
	WebElement endDate;

	@FindBy(xpath = "//div[normalize-space()='Select Category']")
	WebElement selectCategory;

	@FindBy(xpath = "//div[@class='menu-items']")
	WebElement categoryMenuItem;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveCourse;

	@FindBy(xpath = "//tbody")
	WebElement table;

	@FindBy(xpath = "//tbody//tr")
	List<WebElement> tableRow;

	@FindBy(xpath = "//tbody//tr[7]//td[12]//button")
	WebElement deleteBtn;

	@FindBy(xpath = "//thead//th")
	List<WebElement> tableColumn;

	public int beforeCount;
	public int afterCount;

	public First() {
		PageFactory.initElements(driver, this);

	}

	public String verifyUserLandToLoginPage() throws Throwable {
		Helper.waitForElementToBeVisible(driver, navBar, Duration.ofSeconds(10));
		if (navBar.isDisplayed()) {
			navBar.click();
			Helper.waitTillElementToBeClickable(driver, loginBTN, Duration.ofSeconds(10));
			loginBTN.click();
			Helper.waitTillElementToBeClickable(driver, crossNavBar, Duration.ofSeconds(10));
			crossNavBar.click();
			Thread.sleep(1000);
			System.out.println(driver.getCurrentUrl());
			return driver.getCurrentUrl();

		}
		return null;

	}

	public void enterCred() throws Throwable {

		Helper.waitForElementToBeVisible(driver, emailInput, Duration.ofSeconds(10));
		emailInput.sendKeys("admin@email.com");
		Helper.waitForElementToBeVisible(driver, passwordInput, Duration.ofSeconds(10));
		passwordInput.sendKeys("admin@123");
		Helper.waitTillElementToBeClickable(driver, signInBTN, Duration.ofSeconds(10));
		signInBTN.click();

	}

	public boolean verifyWelcomeMessage() {

		Helper.waitForElementToBeVisible(driver, welcomeMsg, Duration.ofSeconds(10));
		if (welcomeMsg.isDisplayed()) {
			System.out.println(welcomeMsg.getText());
			return true;
		}
		return false;
	}

	public void hoverToMangeTab() throws Throwable {
		Helper.waitForElementToBeVisible(driver, manageTab, Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		actions.moveToElement(manageTab).perform();
		Helper.waitTillElementToBeClickable(driver, manageCourses, Duration.ofSeconds(10));
		manageCourses.click();

	}

	public void fillFormToAddCourse() throws Throwable {
		Helper.waitTillElementToBeClickable(driver, addCourse, Duration.ofSeconds(10));
		addCourse.click();
		Helper.waitTillElementToBeClickable(driver, selectThumbnail, Duration.ofSeconds(10));
		String imagePath = System.getProperty("user.dir") + "/src/main/resources/science_of_selenium.jpg";
		selectThumbnail.sendKeys(imagePath);

		courseName.clear();
		courseName.sendKeys("Science of selenium");

		courseDesciption.clear();
		courseDesciption.sendKeys("This course help you to gain knowledge of selenium in depth");

		instructorName.clear();
		instructorName.sendKeys("Mukesh Otwani");

		coursePrice.clear();
		coursePrice.sendKeys("499");

	}

	public void selectStartDateFromcalander() {
		startDateField.click();
		Helper.waitForElementToBeVisible(driver, currentMonthAndYear, Duration.ofSeconds(10));
		String monthYearVal = currentMonthAndYear.getText();
		log.info("Current month and year :" + monthYearVal);
		String month = monthYearVal.split(" ")[0].trim();
		String year = monthYearVal.split(" ")[1].trim();

		while (!(month.equals(prop.getProperty("startMonth")) && year.equals(prop.getProperty("startYear")))) {
			nextMonth.click();
			Helper.waitForElementToBeVisible(driver, currentMonthAndYear, Duration.ofSeconds(10));
			monthYearVal = currentMonthAndYear.getText();
			month = monthYearVal.split(" ")[0].trim();
			year = monthYearVal.split(" ")[1].trim();
		}
		Helper.waitForElementToBeVisible(driver, startDate, Duration.ofSeconds(10));
		startDate.click();
		log.info("Selected Month and year :" + monthYearVal);
		Helper.waitForElementToBeVisible(driver, startDateField, Duration.ofSeconds(10));
		log.info("Selected start date is :" + startDateField.getAttribute("value"));

	}

	public void selectEndDateFromcalander() {
		endDateField.click();
		Helper.waitForElementToBeVisible(driver, currentMonthAndYear, Duration.ofSeconds(10));
		String monthYearVal = currentMonthAndYear.getText();
		log.info("Current month and year :" + monthYearVal);
		String month = monthYearVal.split(" ")[0].trim();
		String year = monthYearVal.split(" ")[1].trim();

		while (!(month.equals(prop.getProperty("endMonth")) && year.equals(prop.getProperty("endYear")))) {
			nextMonth.click();
			Helper.waitForElementToBeVisible(driver, currentMonthAndYear, Duration.ofSeconds(10));
			monthYearVal = currentMonthAndYear.getText();
			month = monthYearVal.split(" ")[0].trim();
			year = monthYearVal.split(" ")[1].trim();
		}
		Helper.waitForElementToBeVisible(driver, endDate, Duration.ofSeconds(10));
		endDate.click();
		log.info("Selected Month and year :" + monthYearVal);
		Helper.waitForElementToBeVisible(driver, endDateField, Duration.ofSeconds(10));
		log.info("Selected end date is :" + endDateField.getAttribute("value"));

	}

	public String chooseCatorgy(String user) {
		selectCategory.click();
		Helper.waitTillElementToBeClickable(driver, categoryMenuItem, Duration.ofSeconds(10));
		WebElement selectItem = driver.findElement(By.xpath("//button[normalize-space()='" + user + "']"));
		selectItem.click();
		Helper.waitTillElementToBeClickable(driver, saveCourse, Duration.ofSeconds(10));
		saveCourse.click();
		return driver.getCurrentUrl();

	}

	public void verifyBeforeCourseCount() {
		Helper.waitForElementToBeVisible(driver, table, Duration.ofSeconds(10));
		log.info("Count of couse before adding new course :" + tableRow.size());
		beforeCount = tableRow.size();
		// return tableRow.size();
	}

	public void verifyAfterCourseCount() {
		Helper.waitForElementToBeVisible(driver, table, Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		List<WebElement> totalCourse = wait
				.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody//tr"), beforeCount + 1));
		log.info("Count of couse after adding new course :" + totalCourse.size());
		afterCount = totalCourse.size();

	}

	public boolean matchCourseCount() {
		if (beforeCount < afterCount) {
			log.info("Course Added sucessfully !!!");
			return true;
		}
		return false;

	}

	public void deleteCourse() throws Throwable {
		Helper.waitForElementToBeVisible(driver, table, Duration.ofSeconds(10));
		System.out.println(tableRow.size());
		System.out.println(tableColumn.size());
		Thread.sleep(3000);

		WebElement dltLastCourse = driver
				.findElement(By.xpath("//tbody//tr[" + tableRow.size() + "]//td[" + tableColumn.size() + "]//button"));
		// Thread.sleep(5000);
		// js.executeScript("arguments[0].scrollIntoView(true);",dltLastCourse);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		// js.executeScript("window.scrollTo(0,550)", "");
		// js.executeScript("window.scrollBy(0,2000)");
		// WebElement dltLastCourse=
		// driver.findElement(By.xpath("//tbody//tr[5]//td[12]//button"));

//		Actions actionObject = new Actions(driver);
//		actionObject.sendKeys(Keys.ARROW_DOWN).build().perform();

		dltLastCourse.click();
		Thread.sleep(3000);
		System.out.println(tableRow.size());
		System.out.println(tableColumn.size());

	}
	
	public String signOut() throws Throwable
	{
		navBar.click();
		Helper.waitTillElementToBeClickable(driver, signOutBTN, Duration.ofSeconds(10));
		signOutBTN.click();
		Helper.waitTillElementToBeClickable(driver, crossNavBar, Duration.ofSeconds(10));
		crossNavBar.click();
		Thread.sleep(3000);
		return driver.getCurrentUrl();
	}

}
