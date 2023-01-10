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
import com.qa.package1.SwitchToWindows;

public class SwitchToWindowsTest extends Testbase {

	Logger log = Logger.getLogger(AssignmentThreeTest.class);

	SwitchToWindows switchToWindows;

	public SwitchToWindowsTest() {

		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		switchToWindows = new SwitchToWindows();

	}

	@Test(priority = 1)
	public void verifySocialLinksTest() throws Throwable {

		switchToWindows.verifySocialLinks();
	}

	@Test(priority = 2)
	public void switchByPageTitleTest() throws Throwable {

		switchToWindows.switchByPageTitle("TwITtEr");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
