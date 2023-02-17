package come.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.package1.Helper;
import com.qa.util.CustomDataProvider;

public class FillFormUsingExcel {

	WebDriver driver;
	JavascriptExecutor js;

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));

		js = (JavascriptExecutor) driver;

	}

	@Test(dataProvider = "credentials", dataProviderClass = CustomDataProvider.class)
	public void test1(String uname, String email, String pass, String intrest, String gender) throws Throwable {
		System.out.println("************* Test Started **************");

		By signUp = By.xpath("//a[normalize-space()='New user? Signup']");
		Helper.waitTillElementToBeClickable(driver, signUp, Duration.ofSeconds(10));
		Helper.clickOnElement(driver, signUp);

		WebElement signUpLoader = driver.findElement(By.xpath("//div[@class='content']"));
		Helper.waitForElementToBeVisible(driver, signUpLoader, Duration.ofSeconds(10));

		By nameInput = By.xpath("//input[@id='name']");
		Helper.waitTillElementToBeClickable(driver, nameInput, Duration.ofSeconds(10));
		Helper.type(driver, nameInput, uname);

		By emailInput = By.xpath("//input[@id='email']");
		Helper.waitTillElementToBeClickable(driver, emailInput, Duration.ofSeconds(10));
		Helper.type(driver, emailInput, email);

		By passInput = By.xpath("//input[@id='password']");
		Helper.waitTillElementToBeClickable(driver, passInput, Duration.ofSeconds(10));
		Helper.type(driver, passInput, pass);

		chooseIntrest(intrest);

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		selectGender(gender);

		System.out.println("************* Test Completed **************");

	}

	public void chooseIntrest(String intrest) {
		By chooseIntrest = By.xpath("//label[normalize-space()='" + intrest + "']");
		Helper.waitTillElementToBeClickable(driver, chooseIntrest, Duration.ofSeconds(10));
		Helper.clickOnElement(driver, chooseIntrest);
	}

	public void selectGender(String gender) {
		By selectGender = By.xpath("//input[@id='" + gender + "']");
		Helper.waitTillElementToBeClickable(driver, selectGender, Duration.ofSeconds(10));
		Helper.clickOnElement(driver, selectGender);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
