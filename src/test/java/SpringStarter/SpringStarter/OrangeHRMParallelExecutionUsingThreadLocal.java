package SpringStarter.SpringStarter;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

 public class OrangeHRMParallelExecutionUsingThreadLocal extends ThreadLocalBaseTestClass{

	static By username = By.xpath("//input[@name='username']");
	static By password = By.xpath("//input[@name='password']");
	static By loginButton = By.xpath("//button[@type='submit']");
	static By adminLocator = By.xpath("//a//span[text()='Admin']");
	static By confirmDeleteUsers = By.xpath("//div[@role='document']/button/following-sibling::div/button/i[contains(@class,'trash')]");
	static By usersLocatorOnAdminPage = By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border' and @role='row']/div");
	static By numberOfRecordsOnAdminPage = By.xpath("//div/span[@class='oxd-text oxd-text--span']");
	static By deleteSelctedUsers = By.xpath("//button/i[@class='oxd-icon bi-trash-fill oxd-button-icon']");
	static String loginUserName = "Admin";
	static String loginPassword = "admin123";
	static String providedUsernameForSelction = "";
	static String dynamiUserCheckBoxSelection = "//div[contains(@class,'oxd-table-row')]//div[text()='"+providedUsernameForSelction+"']/parent::div/parent::div//div[@class='oxd-checkbox-wrapper']";

	
	@DataProvider(name="usercheckList")
	public Object[][] provideUserName(){
		return new Object[][] {
			
			{"David.Morris"},{"Dominic.Chase"},{"Ehioze.Ebo"}
		};
	}
	
//	@Test(dataProvider = "usercheckList")
//	public void testUsername(String username, int age, String gender) {
//		
//		System.out.println(age);
//	}
//	
	@Test(description = "Login", priority = 1)
	public void doLogin(){

		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(username).sendKeys(loginUserName);
		driver.findElement(password).sendKeys(loginPassword);
		driver.findElement(loginButton).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Current page title is = " +driver.getTitle());
	}
	
	@Test(description = "Clicking on admin depends upon login", dependsOnMethods = "doLogin")
	public void clickOnAdmin() {
		
		
		driver.findElement(adminLocator).click();
		System.out.println("Getting the Admin page Title =  " +driver.getTitle());
	}
	
	@Test(description = "Get Total user count and details for each user", dependsOnMethods = "clickOnAdmin")
	public void getUserCountOnAdminPage() {

		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(numberOfRecordsOnAdminPage)));
		
		String text = driver.findElement(numberOfRecordsOnAdminPage).getText();
		System.out.println("Total No of Records on Admin Page = " +text);
		
		System.out.println("Finding the users with all of their attributes");
		List<WebElement> al = driver.findElements(usersLocatorOnAdminPage);
		//int count=0;
		System.out.println("Size of Array is " +al.size());
		
		
		System.out.println("----Iterting and getting all the users from the Web table----");
		for(int i=1;i<al.size();i++) {
			
			System.out.print(al.get(i).getText()+" |");
			
			System.out.println("");
			
		}
		System.out.println("#####Iteration done#####");
	}
	
	@Test(enabled = false,dataProvider = "usercheckList", dependsOnMethods = "getUserCountOnAdminPage")
	public void perfromMultiSelction(String usernameToBeSelcted) {
		
		driver.findElement(By.xpath("//div[contains(@class,'oxd-table-row')]//div[text()='"+usernameToBeSelcted+"']/parent::div/parent::div//div[@class='oxd-checkbox-wrapper']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		//driver.quit();
	
	}
	
	@Test(enabled = false, description = "Deleting the selected users", dependsOnMethods = "perfromMultiSelction")
	public void deletedSelectedUsers() {
		
		driver.findElement(deleteSelctedUsers).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(confirmDeleteUsers)));
		
		driver.findElement(confirmDeleteUsers).click();;
		
	}
	
	@Test(enabled = false ,dataProvider = "usercheckList" ,description = "Validating if the users are deleted or not", dependsOnMethods = "deletedSelectedUsers")
	public void validateUserDeletion(String usernameToBeValidatePostDeletion) {
		try {
		driver.findElement(By.xpath("//div[contains(@class,'oxd-table-row')]//div[text()='"+usernameToBeValidatePostDeletion+"']/parent::div/parent::div//div[@class='oxd-checkbox-wrapper']")).click();
		}
		catch (Exception e) {
			System.out.println("Element not found as user is deleted");
		}
	}
}

