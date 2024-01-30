package SpringStarter.SpringStarter;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.selenium.webelements.utilities.Listners;


@Listeners({Listners.class})

public class TestListenersImpl {

	
	@Test
	public void testStart() {
		System.out.println("Started");
		Assert.assertFalse(true);
	}
}
