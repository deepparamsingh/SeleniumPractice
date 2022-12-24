package come.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.package1.AssignmentFour;
import com.qa.package1.Helper;

public class AssignmentFourTest extends Testbase {
	

	AssignmentFour assignmenFour;
	Helper help;
	
	
	public  AssignmentFourTest() {
			
		super();
		
	}
	
	@BeforeMethod
   public void setup()
   {
	   initialization();
	   assignmenFour= new 	AssignmentFour();
	   help = new Helper();
   }
   

	@Test(priority=1)
	public void verifyH2textTest() throws Throwable
	{
		System.out.println("Verify H2 text is visible on the page");
	    Assert.assertTrue(assignmenFour.verifyH2text());
	}
	
	@Test(priority=2)
	public void verifyFooterAndClickPageTest() throws Throwable
	{
		System.out.println("Verify create page link is available in footer");
	    assignmenFour.verifyFooterAndClickPage("create page");
	    
	    System.out.println("Verify current page URL conatins this word");
	    Assert.assertTrue(help.isCurrentURLcontains("create"));
	}
	

	@Test(priority=3)
	public void signUpnewUserTest() throws Throwable
	{
		System.out.println("Create new account");
		assignmenFour.signUpnewUser();
		
		System.out.println("Verify current page URL conatins this word");
		Assert.assertTrue(help.isCurrentURLcontains("confirmemail"));
	}
	
	


	
	

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
