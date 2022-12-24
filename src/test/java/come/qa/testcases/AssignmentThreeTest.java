package come.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.package1.AssignmentFour;
import com.qa.package1.AssignmentThree;
import com.qa.package1.AssignmentTwo;
import com.qa.package1.Helper;

public class AssignmentThreeTest extends Testbase {
	
	
	AssignmentThree assignmentThree;
	AssignmentTwo assignmentTwo;
	Helper help;
	
	
	public  AssignmentThreeTest() {
			
		super();
		
	}
	
	@BeforeMethod
   public void setup()
   {
	   initialization();
	   assignmentThree= new AssignmentThree();
	   assignmentTwo = new AssignmentTwo();
	   help = new Helper();
   }
   

	@Test(priority=1)
	public void clickDifferentTabsTest() throws Throwable
	{
		System.out.println("Enter user name");
		assignmentTwo.enterUserName("admin");
		
		System.out.println("Enter password");
		assignmentTwo.enterPassword("admin123");
		
		System.out.println("Click on LOGIN button");
		help.clickLoginBTN();
		
		System.out.println("Click on PIM tab");
		help.clickTab("PIM");
		Assert.assertTrue(help.isCurrentURLcontains("pim"));
		
		System.out.println("Click on Admin");
		help.clickTab("Admin");
		Assert.assertTrue(help.isCurrentURLcontains("admin"));
		
		System.out.println("Click on Leave button");
		help.clickTab("Leave");
		Assert.assertTrue(help.isCurrentURLcontains("leave"));
	}
	
	
	
	@Test(priority = 2)
	public void compareTabListwithActualTest() throws Throwable
	{
		System.out.println("Enter user name");
		assignmentTwo.enterUserName("admin");
		
		System.out.println("Enter password");
		assignmentTwo.enterPassword("admin123");
		
		System.out.println("Click on LOGIN button");
		help.clickLoginBTN();
		
		Assert.assertTrue(assignmentThree.verifyTabListwithActual());
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
