package com.qa.package1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class ScreenShot extends Testbase {

	Logger log = Logger.getLogger(AssignmentFour.class);

	@FindBy(xpath = "//input[@title='Sign in']")
	WebElement signInBtn;

	public ScreenShot() {
		PageFactory.initElements(driver, this);
	}

	public void VerifyScreenShot() throws Throwable {
		signInBtn.click();
		Robot robot = new Robot();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(dimension);
		BufferedImage bufferedImage = robot.createScreenCapture(rect);
		String screenshotPath = System.getProperty("user.dir")+"//screenshots//robot.png";
		ImageIO.write(bufferedImage,"png",new File(screenshotPath));
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	

	}

}
