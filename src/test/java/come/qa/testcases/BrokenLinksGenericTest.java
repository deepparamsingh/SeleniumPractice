package come.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.package1.AssignmentTwo;
import com.qa.package1.BrokenLinksGeneric;
import com.qa.package1.Helper;

public class BrokenLinksGenericTest extends Testbase {

	Logger log = Logger.getLogger(BrokenLinksGenericTest.class);

	BrokenLinksGeneric brokenLinksGeneric;
	AssignmentTwo assignmentTwo;
	Helper helper;

	public BrokenLinksGenericTest() {

		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		helper = new Helper();
		assignmentTwo = new AssignmentTwo();
		brokenLinksGeneric = new BrokenLinksGeneric();

	}

	@Test(priority = 1)
	public void uploadFileTest() throws Throwable {
		assignmentTwo.enterUserName("Admin");
		assignmentTwo.enterPassword("admin123");
		helper.clickLoginBTN();
		Thread.sleep(5000);

		System.out.println("Check Current Page Broaken Links");
		brokenLinksGeneric.Check_BrokenLinks_of_CurrentPage();

	}

}
