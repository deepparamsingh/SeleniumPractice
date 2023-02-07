package come.qa.testcases;

import org.testng.annotations.Test;

import com.qa.util.CustomDataProvider;

public class DataProviderSeleniumTest {
	

	@Test(dataProvider = "credentials", dataProviderClass = CustomDataProvider.class)
	public void test1(String uname,String pass,String skillset)
	{
		System.out.println("************* Test Started **************");
		System.out.println("Username is "+uname);
		System.out.println("Password is "+pass);
		System.out.println("SkillSet is "+skillset);
		//System.out.println("Random values "+randomValues);
		System.out.println("************* Test Completed **************");
		
	}

	
	

}
