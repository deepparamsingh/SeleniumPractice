package come.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.package1.AssignmentOne;
import com.qa.package1.Helper;

public class AssignmentOneTest extends Testbase {

	
	AssignmentOne assignmentOne;
	Helper help;
	
	
	public  AssignmentOneTest() {
			
		super();
		
	}
	
	@BeforeMethod
   public void setup()
   {
	   initialization();
	   assignmentOne= new AssignmentOne();
	   help = new Helper();
   }
   

	@Test(priority=1)
	public void verifyURLEndsWithTest() throws Throwable
	{
	System.out.println("Verify your current URL end's with this word");
	  Assert.assertTrue(help.URLEndsWith("login"));
	}
	
	@Test(priority=1)
	public void verifyURLContainsTest() throws Throwable
	{
		System.out.println("Verify your current URL contains this word");
		Assert.assertTrue(help.isCurrentURLcontains("demo"));
	}
	
	@Test(priority=1)
	public void verifyTitleContainsTest() throws Throwable
	{
		System.out.println("Verify your URL title contains this word");
		Assert.assertTrue(help.verifyTitleContains("HRM"));
	}
	
	@Test(priority=2)
	public void verifySiteLogoTest() throws Throwable
	{
	  System.out.println("Verify that your site logo is visible");	
	  Assert.assertTrue(assignmentOne.verifySiteLogo());
	}
	
	@Test(priority=3)
	public void verifySocialLinksTest() throws Throwable
	{
		
	  System.out.println("Verify that your webpage have all four social media links");
	  Assert.assertEquals(assignmentOne.verifySocialLinks(), 4);
	}
	
	@Test(priority=4)
	public void verifySocialLinksWithMAPTest() throws Throwable
	{
		//System.out.println("Verify that your social media links have youtube link as well");
		assignmentOne.verifySocialLinksWithMAP();
	}
	

	@Test(priority=5)
	public void verifyYTlinkExistTest() throws Throwable
	{
		System.out.println("Verify that your social media links have youtube link as well");
		Assert.assertTrue(assignmentOne.verifyYTlinkExist());
	}
	

	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
     	
}
