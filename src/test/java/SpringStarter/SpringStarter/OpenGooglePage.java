package SpringStarter.SpringStarter;

import org.testng.annotations.Test;

public class OpenGooglePage extends ThreadLocalBaseTestClass {

	
	
	
	@Test
	public void launchGoogle() {
		
		
		driver.get("https://www.google.com");
		System.out.println("Current page title is " +driver.getTitle());
		
	}
	
}
