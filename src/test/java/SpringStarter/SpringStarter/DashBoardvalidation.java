package SpringStarter.SpringStarter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.selenium.webelements.utilities.Listners;


@Listeners(Listners.class)
public class DashBoardvalidation extends BaseTestClass{

	
	By widgetOnDashBoards = By.xpath("//div[contains(@class,'oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget')]//p");
	By dashBoardButton = By.xpath("//a//span[text()='Dashboard']");
	@Test()
	public void getDetailsOfWidgetsOnDashBoard() {
		
		
		wait.until(ExpectedConditions.visibilityOf(element.getWebElement(dashBoardButton)));
		driver.findElement(dashBoardButton).click();
		//wait.until(ExpectedConditions.visibilityOf(element.getWebElement(widgetOnDashBoards)));
		List<WebElement> detailsOfEachWidgets = driver.findElements(widgetOnDashBoards);
		
		detailsOfEachWidgets.stream().forEach(i->{
			System.out.println(i.getText());
		});
		
		screenshot.takeScreenshot(driver, "getDetailsOfWidgetsOnDashBoard");
	}
}
