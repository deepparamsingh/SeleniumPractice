package come.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.package1.AssignmentOne;
import com.qa.package1.Helper;
import com.qa.package1.ScreenShot;

public class ScreenShotTest extends Testbase {

	Logger log = Logger.getLogger(ScreenShotTest.class);
	ScreenShot screenShot;

	public ScreenShotTest() {

		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		screenShot = new ScreenShot();
	}

	@Test(priority = 1)
	public void VerifyScreenShotTest() throws Throwable {
		screenShot.VerifyScreenShot();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
