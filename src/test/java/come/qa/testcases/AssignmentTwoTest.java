package come.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.package1.AssignmentTwo;
import com.qa.package1.Helper;

public class AssignmentTwoTest extends Testbase {
	
	AssignmentTwo assignmentTwo;
	Helper help;
	
	
	public  AssignmentTwoTest() {
			
		super();
		
	}
	
	@BeforeMethod
   public void setup()
   {
	   initialization();
	   assignmentTwo= new AssignmentTwo();
	   help = new Helper();
   }
   

	@Test(priority=1)
	public void verifyEmptyUNvalidationTest() throws Throwable
	{
		System.out.println("Click on LOGIN button");
		help.clickLoginBTN();
		
		System.out.println("Verify validation for empty user name input field");
		Assert.assertTrue(help.verifyEmptyLoginvalidation());
	}
	
	@Test(priority=1)
	public void verifyEmptyPasswordValidationTest() throws Throwable
	{
		System.out.println("Click on LOGIN button");
		help.clickLoginBTN();
		
		System.out.println("Verify validation for empty password input field");
		Assert.assertTrue(help.verifyEmptyLoginvalidation());
	}
	
	@Test(priority=1)
	public void verifyCSSpropertyTest() throws Throwable
	{
		System.out.println("Verify border value of input field");
		Assert.assertTrue(assignmentTwo.UNcssProperties());
	}
	
	@Test(priority=2)
	public void verifyPasswordValidationTest() throws Throwable
	{
		
		System.out.println("Enter user name");
		assignmentTwo.enterUserName("admin");
		
		System.out.println("Click on LOGIN button");
		help.clickLoginBTN();	
		Thread.sleep(3000);
		System.out.println("Verify validation for empty password input field");
		Assert.assertTrue(help.verifyEmptyLoginvalidation());	
		
	}
	
	@Test(priority=3)
	public void verifyInvalidAlertTest() throws Throwable
	{
		System.out.println("Enter user name");
		assignmentTwo.enterUserName("admin");
		
		System.out.println("Enter password");
		assignmentTwo.enterPassword("mukesh");
		
		System.out.println("Click on LOGIN button");
		help.clickLoginBTN();
		
		System.out.println("Verify invalid alert message");
		Assert.assertTrue(assignmentTwo.verifyInvalidAlert());
	}
	
	@Test(priority=4)
	public void loginLogoutTest() throws Throwable
	{
		System.out.println("Enter user name");
		assignmentTwo.enterUserName("admin");
		
		System.out.println("Enter user name");
		assignmentTwo.enterPassword("admin123");
		
		System.out.println("Click on LOGIN button");
		help.clickLoginBTN();
		
		System.out.println("Verify your current URL contains this word");
		Assert.assertTrue(help.isCurrentURLcontains("dashboard"));
		
		System.out.println("Click yor profile Image");
		help.clickYourProfileImg();
		
		System.out.println("Click on LOGOUT button");
		help.logOut();
		
		System.out.println("Verify your current URL contains this word");
		Assert.assertTrue(help.isCurrentURLcontains("login"));	
		
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
