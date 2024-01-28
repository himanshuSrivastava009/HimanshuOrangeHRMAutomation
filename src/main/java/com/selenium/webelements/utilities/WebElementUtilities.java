package com.selenium.webelements.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementUtilities {

	WebDriver driver;

	public WebElementUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getWebElement(By locator) {

		return driver.findElement(locator);
	}
}
