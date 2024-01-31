package com.selenium.webelements.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollUpAndDownUtility {

	private JavascriptExecutor js = null;

	WebDriver driver = null;

	public ScrollUpAndDownUtility(WebDriver driver) {
		

		this.driver = driver;
		this.js = (JavascriptExecutor) (this.driver);
	}
	/***
	 * Method used for Scrolling up and down once driver instance 
	 * and Web element is provided
	 * @param driver
	 * @param element
	 */
	public void scrollUpAndDown(WebElement element) {

		
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	/***
	 * Method is used to 
	 */
	public void scrollToTheBottomOfThePage() {

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	/***
	 * This method is used for doing infinite scrolling
	 * using Fluent wait
	 * @param locator
	 */

	public void scrollToInfinityUsingFluentWait(By locator) {

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2))
				.withMessage("---Waiting for page to load---").ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.invisibilityOfElementLocated(locator));

	}

	/***
	 * This method is used for doing infinite scrolling
	 * using WebDriver wait
	 * @param driver
	 * @param locator
	 */
	public void scrollToInfinityUsingWebDriverWait(WebDriver driver, By locator) {

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
}
