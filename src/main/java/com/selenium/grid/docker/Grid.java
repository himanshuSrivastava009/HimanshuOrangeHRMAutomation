package com.selenium.grid.docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Grid {

	
	private WebDriver driver;
	
	public void initDriver() throws MalformedURLException {
	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		//capabilities.setPlatform(Platform.MAC);
		
		
		RemoteWebDriver remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
		remoteWebDriver.get("https://www.amazon.com");
	}
	
	public static void main(String[] args) throws MalformedURLException {
		
		Grid grid = new Grid();
		grid.initDriver();
	}
}
