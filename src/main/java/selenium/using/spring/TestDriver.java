package selenium.using.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestDriver {

	// org.openqa.selenium.chrome.ChromeDriver.class

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		LaunchingBrowser lc = new LaunchingBrowser(ac);
		
		lc.initBrowser();
		lc.navigateToURL("https://www.amazon.com");
		lc.quitBrowser();
	
	}
}
