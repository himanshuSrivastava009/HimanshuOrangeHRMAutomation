package selenium.using.spring;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeHrm {

	/***
	 * provides all the six elements in the row //div[contains(@class,'oxd-table-row')]//div[text()='pcaov']/parent::div/parent::div/div
	 * //div[contains(@class,'oxd-table-row')]//div[text()='pcaov']/parent::div/parent::div//div[@class='oxd-checkbox-wrapper']
	 * 
	 * get all the users with their profile
	 * //div[@class='oxd-table-row oxd-table-row--with-border' and @role='row']/div
	 */
	
	static By username = By.xpath("//input[@name='username']");
	static By password = By.xpath("//input[@name='password']");
	static By loginButton = By.xpath("//button[@type='submit']");
	static By adminLocator = By.xpath("//a//span[text()='Admin']");
	static By usersLocatorOnAdminPage = By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border' and @role='row']/div");
	static By numberOfRecordsOnAdminPage = By.xpath("//div/span[@class='oxd-text oxd-text--span']");
	static String loginUserName = "Admin";
	static String loginPassword = "admin123";
	static String providedUsernameForSelction = "";
	static String dynamiUserCheckBoxSelection = "//div[contains(@class,'oxd-table-row')]//div[text()='"+providedUsernameForSelction+"']/parent::div/parent::div//div[@class='oxd-checkbox-wrapper']";
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(username).sendKeys(loginUserName);
		driver.findElement(password).sendKeys(loginPassword);
		driver.findElement(loginButton).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		System.out.println("Current page title is = " +driver.getTitle());
		
		driver.findElement(adminLocator).click();
		System.out.println("Getting the Admin page Title =  " +driver.getTitle());
		
		System.out.println("Finding the users with all of their attributes");
		List<WebElement> al = driver.findElements(usersLocatorOnAdminPage);
		int count=0;
		System.out.println("Size of Array is " +al.size());
		
		String text = driver.findElement(numberOfRecordsOnAdminPage).getText();
		System.out.println("Total No of Records on Admin Page = " +text);
		System.out.println("----Iterting and getting all the users from the Web table----");
		for(int i=1;i<al.size();i++) {
			
			System.out.print(al.get(i).getText()+" |");
			
			System.out.println("");
			
		}
		
		//Perfroming Multi Select
		
		
		System.out.println("#####Iteration done#####");
		driver.quit();
	}
	
	
}
