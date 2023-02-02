package come.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.package1.AssignmentOne;
import com.qa.package1.First;
import com.qa.package1.Helper;

public class FirstTest extends Testbase {

	Logger log = Logger.getLogger(FirstTest.class);
	AssignmentOne assignmentOne;
	First first;
	Helper help;

	public FirstTest() {

		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		first = new First();
		help = new Helper();
	}

	@Test(priority = 1)
	public void verifyTitleContainsTest() throws Throwable {
		log.info("Verify your URL title contains this word");
		Assert.assertTrue(help.verifyTitleContains("Automation"));
	}

	@Test(priority = 2)
	public void verifyUserLandToLoginPageTest() throws Throwable {
		log.info("Click on side nav bar and click on login");
		Assert.assertEquals(first.verifyUserLandToLoginPage(), "https://freelance-learn-automation.vercel.app/login");

		log.info("Enter the credentials");
		first.enterCred();

		log.info("Verify Welcome message");
		Assert.assertTrue(first.verifyWelcomeMessage());

	}

	@Test(priority = 3)
	public void addCourseTest() throws Throwable {
		log.info("Click on side nav bar and click on login");
		Assert.assertEquals(first.verifyUserLandToLoginPage(), "https://freelance-learn-automation.vercel.app/login");

		log.info("Enter the credentials");
		first.enterCred();

		log.info("Verify Welcome message");
		Assert.assertTrue(first.verifyWelcomeMessage());

		log.info("Hover to manage Tab and click on manage courses");
		first.hoverToMangeTab();

		first.verifyBeforeCourseCount();

		log.info("Fill form to add course");
		first.fillFormToAddCourse();

		log.info("Select start date of course");
		first.selectStartDateFromcalander();

		log.info("Select end date of course");
		first.selectEndDateFromcalander();

		log.info("Click and select category");
		Assert.assertEquals(first.chooseCatorgy("Automation Testing"),
				"https://freelance-learn-automation.vercel.app/course/manage");
		
		log.info("Verify count of the course list");
		first.verifyAfterCourseCount();
		
		log.info("Verify course added successfully");
		Assert.assertTrue(first.matchCourseCount());
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

}
