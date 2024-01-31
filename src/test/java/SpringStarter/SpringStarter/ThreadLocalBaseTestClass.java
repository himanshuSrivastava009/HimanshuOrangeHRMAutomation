package SpringStarter.SpringStarter;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.selenium.webelements.utilities.ScrollUpAndDownUtility;
import com.selenium.webelements.utilities.TakeScreenshotUtility;
import com.selenium.webelements.utilities.WebElementUtilities;

public class ThreadLocalBaseTestClass {

	//static public WebDriver driver = null;
	static public ChromeDriver driver = null;
	static WebDriverWait wait = null;
	static WebElementUtilities element = null;
	static TakeScreenshotUtility screenshot = null;
	static ScrollUpAndDownUtility scroll = null;
	private static ThreadLocal<ChromeDriver> tl = new ThreadLocal<>();
	
	static {
		tl.set(new ChromeDriver());
		
	}
	@BeforeSuite
	public void initDriver() {
		
		//driver = new ChromeDriver();
		driver = tl.get();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		element = new WebElementUtilities(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		screenshot = new TakeScreenshotUtility();
		scroll = new ScrollUpAndDownUtility(driver);
		
		
		
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	
	
}
