package SpringStarter.SpringStarter;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Guru99Demo extends ThreadLocalBaseTestClass{

	String infinitePageScrollDemoURL = "https://infinite-scroll.com/demo/full-page/";
	String url = "https://testsigma.com/blog/scrolling-in-selenium/";
	By linkedinLocator = By.xpath("//a[contains(@href,'shresth')]");
	By infiniteLocator = By.xpath("//a[text()='using Isotope with Webpack']");
	
	@Test
	public void testScrollUpAndDown() {
		
		driver.get(infinitePageScrollDemoURL);
		scroll.scrollToInfinityUsingFluentWait(infiniteLocator);
		
		//Actions action = new Actions(driver);
		//action.moveToElement(element.getWebElement(linkedinLocator)).build().perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
