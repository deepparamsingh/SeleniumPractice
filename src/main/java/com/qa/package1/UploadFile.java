package com.qa.package1;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.Testbase;

public class UploadFile extends Testbase {

	@FindBy(css = "input#uploadFile")
	WebElement uploadFileBTN;

	public UploadFile() {
		PageFactory.initElements(driver, this);
	}

	public void uploadFile() throws Throwable {
		//-------------- upload using send keys -----------
		//uploadFileBTN.sendKeys("C:\\Users\\k.jgdahv\\Desktop\\kill driver.txt");
		
		//------------ upload using action class ---------		
		Actions act = new Actions(driver);
		act.moveToElement(uploadFileBTN).click().perform();
		
		Robot rb = new Robot();
		rb.delay(2000);
		
		//copy file to clipboard - you can change file path in config file
		String file= prop.getProperty("file");
		StringSelection ss = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);	
		
		//perform control+V actions to paste file
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
	
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_V);
		
		Thread.sleep(3000);
	}

}
