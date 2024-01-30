package SpringStarter.SpringStarter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateUser extends BaseTestClass {

	By selectUserType = By.xpath("//div[@role='listbox']/div//span");// provide all the options
	By adminLocator = By.xpath("//a//span[text()='Admin']");
	By addUserButton = By.xpath("//button[@type='button']/i[@class='oxd-icon bi-plus oxd-button-icon']");
	By selectUserRoleFromDropDown = By.xpath("//div[@role='listbox']/div[@role='option']/span");

	@DataProvider(name = "UserFields")
	public Object[][] getUserAttributes() {

		return new Object[][] { { "Employee Name" }, { "Username" }, { "Password" }, { "Confirm Password" } };
	}

	@DataProvider(name = "userStatusAndRole")
	public Object[][] getUserStatusAndRole() {

		return new Object[][] { { "User Role" }, { "Status" } };
	}

	@Test()
	public void clickOnAdmin() {

		wait.until(ExpectedConditions.visibilityOf(element.getWebElement(adminLocator)));
		driver.findElement(adminLocator).click();
		System.out.println(driver.getTitle());
	}

	@Test(dependsOnMethods = "clickOnAdmin")
	public void clickOnAddUserButton() {

		driver.findElement(addUserButton).click();

	}


	@Test(dependsOnMethods = "clickOnAddUserButton", dataProvider = "userStatusAndRole")
	public void selectOptionFromDropDown(String role) {
		By userRole = By.xpath("//label[contains(text(),'" + role
				+ "')]/parent::div/following-sibling::div//*[@class='oxd-select-wrapper']");

		wait.until(ExpectedConditions.elementToBeClickable(element.getWebElement(userRole)));
		driver.findElement(userRole).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> options = driver.findElements(selectUserRoleFromDropDown);
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().equals("Admin")) {
				options.get(i).click();
				break;

			} else if (options.get(i).getText().equals("Enabled")) {

				options.get(i).click();
				break;
			}
		}
	}

	@Test(dependsOnMethods = "selectOptionFromDropDown", dataProvider = "UserFields")
	public void enterUserDetails(String userDetails) {

		By employeeDetails = By
				.xpath("//label[normalize-space()='" + userDetails + "']/parent::div/following-sibling::div//input");
		wait.until(ExpectedConditions.visibilityOf(element.getWebElement(employeeDetails)));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// driver.findElement(employeeDetails).click();
		if (userDetails.equals("Employee Name")) {
			
			driver.findElement(employeeDetails).sendKeys("car");
			wait.until(ExpectedConditions.visibilityOf(element.getWebElement(selectUserRoleFromDropDown)));
			
			List<WebElement> userHints = driver.findElements(selectUserRoleFromDropDown);
			userHints.stream().forEach(i->{
			
				if(i.getText().equalsIgnoreCase("Charlie Carter")) {
					i.click();
				}
				else {
					System.out.println("-Error--User not Found--Error-");
			
				}
			});
			}
		else if(userDetails.equals("Password")||userDetails.equals("Confirm Password")) {
			
			driver.findElement(employeeDetails).sendKeys("Himanshu@123E");
		}
		else if(userDetails.equals("Username")) {
			
			driver.findElement(employeeDetails).sendKeys("Himanshu");
		}
		else {
			System.out.println("no Matching operations found**** please Check *****");
		}

		
	}
}
