package come.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.package1.UploadFile;

public class UploadFileTest extends Testbase {
	
	Logger log = Logger.getLogger(UploadFileTest.class);

	UploadFile uploadFile;

	public UploadFileTest() {

		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		uploadFile = new UploadFile();
		
	}

	@Test(priority = 1)
	public void uploadFileTest() throws Throwable {
		log.info("Upload the file");
		uploadFile.uploadFile();
		
	}

}
