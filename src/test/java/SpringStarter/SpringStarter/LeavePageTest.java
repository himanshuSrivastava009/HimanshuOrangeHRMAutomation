package SpringStarter.SpringStarter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LeavePageTest extends BaseTestClass{

	By leavePageButton = By.xpath("//a//span[text()='Leave']");
	By fromDate = By.xpath("//div/label[contains(text(),'From')]/parent::div/following-sibling::div//input");
	By toDate = By.xpath("//div/label[contains(text(),'To Date')]/parent::div/following-sibling::div//input");
	By monthClickerToGetList = By.xpath("//ul[@class='oxd-calendar-selector']//div[@class='oxd-calendar-selector-month-selected']");
	By yeatClickerToGetList = By.xpath("//ul[@class='oxd-calendar-selector']//div[@class='oxd-calendar-selector-year-selected']");
	By monthPicker = By.xpath("//div[@class='oxd-date-input-calendar']//ul/li[contains(@class,'oxd-calendar-dropdown--option')]");
	By yearPicker = By.xpath("//div[@class='oxd-calendar-selector-year-selected']/following-sibling::ul/li[contains(@class,'oxd-calendar-dropdown')]");
	By datePicker = By.xpath("//div[@class='oxd-calendar-wrapper']//div[@class='oxd-calendar-dates-grid']/div");
	
	String leaveMonth = "October";
	String leaveYear = "2023";
	String leaveDate = "27";
	
	@Test
	public void applyLeave() {
		
		driver.findElement(leavePageButton).click();
		wait.until(ExpectedConditions.visibilityOf(element.getWebElement(fromDate)));
		
		System.out.println("Clicking on the calender input filed");
		driver.findElement(fromDate).click();
		
		System.out.println("Click on the Month picker");
		driver.findElement(monthClickerToGetList).click();
		
		System.out.println("Getting the months");
		List<WebElement> months = driver.findElements(monthPicker);
		for(WebElement elem : months) {
			if(elem.getText().equalsIgnoreCase(leaveMonth)) {
				System.out.println(elem.getText());
				elem.click();
				break;
			}
		}
		
		System.out.println("Click on the Year picker");
		driver.findElement(yeatClickerToGetList).click();
		List<WebElement> years = driver.findElements(yearPicker);
		for(WebElement elem : years) {
			if(elem.getText().equalsIgnoreCase(leaveYear)) {
				System.out.println(elem.getText());
				elem.click();
				break;
			}
		}
		try {
		Thread.sleep(7000);
		}
		catch(Exception e) {
			
		}
		
		System.out.println("Click on the Date");
		List<WebElement> dates = driver.findElements(datePicker);
		for(WebElement elem : dates) {
			if(elem.getText().equalsIgnoreCase(leaveDate)) {
				System.out.println(elem.getText());
				elem.click();
				break;
			}
		}
		try {
			Thread.sleep(7000);
			}
			catch(Exception e) {
				
			}
	}
	
}
