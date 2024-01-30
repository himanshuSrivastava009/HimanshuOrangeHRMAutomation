package com.selenium.webelements.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshotUtility {


	public void takeScreenshot(WebDriver driver, String testCasename) {

		try {
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("/screenshot"+testCasename+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
