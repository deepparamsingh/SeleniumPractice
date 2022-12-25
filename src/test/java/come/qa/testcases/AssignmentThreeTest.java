package come.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.package1.AssignmentThree;
import com.qa.package1.AssignmentTwo;
import com.qa.package1.Helper;

public class AssignmentThreeTest extends Testbase {

	Logger log = Logger.getLogger(AssignmentThreeTest.class);

	AssignmentThree assignmentThree;
	AssignmentTwo assignmentTwo;
	Helper help;

	public AssignmentThreeTest() {

		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		assignmentThree = new AssignmentThree();
		assignmentTwo = new AssignmentTwo();
		help = new Helper();
	}

	@Test(priority = 1)
	public void clickDifferentTabsTest() throws Throwable {
		log.info("Enter user name");
		assignmentTwo.enterUserName("admin");

		log.info("Enter password");
		assignmentTwo.enterPassword("admin123");

		log.info("Click on LOGIN button");
		help.clickLoginBTN();

		log.info("Click on PIM tab");
		help.clickTab("PIM");
		Assert.assertTrue(help.isCurrentURLcontains("pim"));

		log.info("Click on Admin");
		help.clickTab("Admin");
		Assert.assertTrue(help.isCurrentURLcontains("admin"));

		log.info("Click on Leave button");
		help.clickTab("Leave");
		Assert.assertTrue(help.isCurrentURLcontains("leave"));
	}

	@Test(priority = 2)
	public void compareTabListwithActualTest() throws Throwable {
		log.info("Enter user name");
		assignmentTwo.enterUserName("admin");

		log.info("Enter password");
		assignmentTwo.enterPassword("admin123");

		log.info("Click on LOGIN button");
		help.clickLoginBTN();

		Assert.assertTrue(assignmentThree.verifyTabListwithActual());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
