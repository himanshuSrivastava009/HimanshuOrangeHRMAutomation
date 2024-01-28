package selenium.using.spring;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.ApplicationContext;

public class LaunchingBrowser {

	ApplicationContext ac;
	ChromeDriver driver;

	public LaunchingBrowser(ApplicationContext ac) {

		this.ac = ac;
	}

	public void initBrowser() {

		driver = (ChromeDriver)ac.getBean("ChromeDriver");
		//this.driver = new ChromeDriver();
		
	}
	
	public void navigateToURL(String url) {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public void quitBrowser() {
		
		driver.quit();
		
	}
}
