package come.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.package1.AssignmentTwo;
import com.qa.package1.Helper;

public class AssignmentTwoTest extends Testbase {

	Logger log = Logger.getLogger(AssignmentTwoTest.class);
	AssignmentTwo assignmentTwo;
	Helper help;

	public AssignmentTwoTest() {

		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		assignmentTwo = new AssignmentTwo();
		help = new Helper();
	}

	@Test(priority = 1)
	public void verifyEmptyUNvalidationTest() throws Throwable {
		log.info("Click on LOGIN button");
		help.clickLoginBTN();

		log.info("Verify validation for empty user name input field");
		Assert.assertTrue(help.verifyEmptyLoginvalidation());
	}

	@Test(priority = 1)
	public void verifyEmptyPasswordValidationTest() throws Throwable {
		log.info("Click on LOGIN button");
		help.clickLoginBTN();

		log.info("Verify validation for empty password input field");
		Assert.assertTrue(help.verifyEmptyLoginvalidation());
	}

	@Test(priority = 1)
	public void verifyCSSpropertyTest() throws Throwable {
		log.info("Verify border value of input field");
		Assert.assertTrue(assignmentTwo.UNcssProperties());
	}

	@Test(priority = 2)
	public void verifyPasswordValidationTest() throws Throwable {

		log.info("Enter user name");
		assignmentTwo.enterUserName("admin");

		log.info("Click on LOGIN button");
		help.clickLoginBTN();
		Thread.sleep(3000);
		log.info("Verify validation for empty password input field");
		Assert.assertTrue(help.verifyEmptyLoginvalidation());

	}

	@Test(priority = 3)
	public void verifyInvalidAlertTest() throws Throwable {
		log.info("Enter user name");
		assignmentTwo.enterUserName("admin");

		log.info("Enter password");
		assignmentTwo.enterPassword("mukesh");

		log.info("Click on LOGIN button");
		help.clickLoginBTN();

		log.info("Verify invalid alert message");
		Assert.assertTrue(assignmentTwo.verifyInvalidAlert());
	}

	@Test(priority = 4)
	public void loginLogoutTest() throws Throwable {
		log.info("Enter user name");
		assignmentTwo.enterUserName("admin");

		log.info("Enter user name");
		assignmentTwo.enterPassword("admin123");

		log.info("Click on LOGIN button");
		help.clickLoginBTN();

		log.info("Verify your current URL contains this word");
		Assert.assertTrue(help.isCurrentURLcontains("dashboard"));

		log.info("Click yor profile Image");
		help.clickYourProfileImg();

		log.info("Click on LOGOUT button");
		help.logOut();

		log.info("Verify your current URL contains this word");
		Assert.assertTrue(help.isCurrentURLcontains("login"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
