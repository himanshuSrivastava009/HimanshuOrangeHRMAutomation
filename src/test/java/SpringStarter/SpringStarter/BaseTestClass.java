package SpringStarter.SpringStarter;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.selenium.webelements.utilities.WebElementUtilities;

public class BaseTestClass {

	static public WebDriver driver = null;
	static WebDriverWait wait = null;
	static WebElementUtilities element = null;

	@BeforeSuite
	public void initDriver() {
		driver = new ChromeDriver();
		element = new WebElementUtilities(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}