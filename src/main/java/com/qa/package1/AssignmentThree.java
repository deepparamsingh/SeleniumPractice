package com.qa.package1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

import com.qa.base.Testbase;

import io.netty.handler.codec.http.HttpHeaders.Names;

public class AssignmentThree extends Testbase {

	Logger log = Logger.getLogger(AssignmentThree.class);

	@FindBy(css = "ul[class*='oxd-main-menu']>li")
	List<WebElement> allMainTabs;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement empNameInput;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement addUserButton;

	@FindBy(xpath = "//div[@role='listbox']//div")
	List<WebElement> empDDlist;

	@FindBy(xpath = "//div[@role='listbox']//div[2]")
	WebElement selectUser;

	@FindBy(xpath = "(//div[@tabindex='0'])[1]")
	WebElement userRole;

	@FindBy(xpath = "(//div[@tabindex='0'])[2]")
	WebElement userStatus;

	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement userPassword;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	WebElement userConfirmPassword;

	String[] array = { "Admin", "PIM", "Leave", "Time", "Recruitment", "My Info", "Performance", "Dashboard",
			"Directory", "Maintenance", "Buzz" };
	List<String> list = Arrays.asList(array);

	public AssignmentThree() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyTabListwithActual() throws Throwable {
		for (int i = 0; i < allMainTabs.size(); i++) {
			String actual = allMainTabs.get(i).getText().trim();
			String existing = list.get(i).trim();

			if (!actual.equals(existing)) {
				log.info("****** " + actual + " not matched with " + existing + " ******");
				return false;
			} else {
				log.info(actual + " equals to " + existing);
			}
		}
		return true;
	}

	public void empNameDDlist() throws Throwable {

		addUserButton.click();
		sendKeys(driver, empNameInput, Duration.ofSeconds(1), "A");
		Thread.sleep(3000);
		for (WebElement names : empDDlist) {
			System.out.println(names.getText());
		}

		selectUser.click();

	}

	/*---- Add new user --------
	      Add new Admin/ESS user
	 */
	public void newUser(String user) {

		WebElement addNewUser = driver.findElement(By.xpath("//div[@role='listbox']//*[text()='" + user + "']"));
		addNewUser.click();

	}

	// ------- Set user status to Enabled/Disabled -----------
	public void newUserStatus(String status) {

		WebElement userStatus = driver
				.findElement(By.xpath("//div[@class='oxd-select-option']//*[text()='" + status + "']"));
		userStatus.click();
	}

	public void addNewUser() throws Throwable {
		addUserButton.click();
		userRole.click();
		Thread.sleep(1000);
		newUser("Admin");
		userStatus.click();
		newUserStatus("Enabled");
		empNameDDlist();
		userPassword.sendKeys("admin123");
		userConfirmPassword.sendKeys("admin123");
	}
}
