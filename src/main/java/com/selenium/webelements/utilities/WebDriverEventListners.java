package com.selenium.webelements.utilities;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebDriverEventListners implements WebDriverListener {

	
	public void beforeTo(Navigation nav, String url) {
		
		nav = new Navigation() {
			
			
			
			@Override
			public void to(String url) {
				
				System.out.println("Before Navigating to" +url);
			}
			
			@Override
			public void refresh() {
				
				System.out.println("On Refresh");
				
			}
			
			@Override
			public void forward() {
				
				System.out.println("On forward");
				
			}
			
			@Override
			public void back() {
				
				System.out.println("Before navigate back");
				
			}

			@Override
			public void to(URL url) {
				
				
			}
		};
		
		nav.refresh();
	}
	
	
	public static void main(String[] args) {
		
		WebDriverEventListners listners = new WebDriverEventListners();
		Navigation nav = new Navigation() {
			
			@Override
			public void to(URL url) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void to(String url) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void refresh() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void forward() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void back() {
				
				
			}
		};
		listners.beforeTo(nav, "https://google.com");
		
		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(listners);
		WebDriver dr = decorator.decorate(new ChromeDriver());
		dr.get("https://www.google.com");
		
	}
}
