package come.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.package1.AssignmentTwo;
import com.qa.package1.Helper;
import com.qa.package1.ScrollWithInElement;

public class ScrollWithInElementTest extends Testbase {
	
	Logger log = Logger.getLogger(ScrollWithInElementTest.class);

	AssignmentTwo assignmentTwo;
	ScrollWithInElement scrollWithInElement;
	Helper help;

	public ScrollWithInElementTest() {

		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		assignmentTwo = new AssignmentTwo();
		scrollWithInElement = new ScrollWithInElement();
		help = new Helper();
	}

	@Test(priority = 1)
	public void verifyH2textTest() throws Throwable {
		
		log.info("Enter user name");
		assignmentTwo.enterUserName("admin");

		log.info("Enter password");
		assignmentTwo.enterPassword("admin123");

		log.info("Click on LOGIN button");
		help.clickLoginBTN();

		log.info("Click on DIRECTORY tab");
		help.clickTab("Directory");
		Assert.assertTrue(help.isCurrentURLcontains("directory"));
		
		Thread.sleep(4000);
		
		log.info("Scroll within element");
		scrollWithInElement.scrollInside();
		
	}

}
