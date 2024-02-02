package SpringStarter.SpringStarter;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.webelements.utilities.RetrytestMechanish;

public class TetsingRetryAnalyzer {

	
	@Test(retryAnalyzer = RetrytestMechanish.class)
	public void doTest() {
		
		System.out.println("Testing Retry");
		Assert.assertFalse(true);
	}
}
