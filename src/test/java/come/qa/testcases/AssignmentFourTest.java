package come.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.package1.AssignmentFour;
import com.qa.package1.Helper;

public class AssignmentFourTest extends Testbase {

	Logger log = Logger.getLogger(AssignmentFourTest.class);

	AssignmentFour assignmenFour;
	Helper help;

	public AssignmentFourTest() {

		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		assignmenFour = new AssignmentFour();
		help = new Helper();
	}

	@Test(priority = 1)
	public void verifyH2textTest() throws Throwable {
		log.info("Verify H2 text is visible on the page");
		Assert.assertTrue(assignmenFour.verifyH2text());
	}

	@Test(priority = 2)
	public void verifyFooterAndClickPageTest() throws Throwable {
		log.info("Verify create page link is available in footer");
		assignmenFour.verifyFooterAndClickPage("create page");

		log.info("Verify current page URL conatins this word");
		Assert.assertTrue(help.isCurrentURLcontains("create"));
	}

	@Test(priority = 3)
	public void signUpnewUserTest() throws Throwable {
		log.info("Create new account");
		assignmenFour.signUpnewUser();

		log.info("Verify current page URL conatins this word");
		Assert.assertTrue(help.isCurrentURLcontains("confirmemail"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
