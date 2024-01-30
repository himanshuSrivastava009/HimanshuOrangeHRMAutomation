package com.selenium.webelements.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners implements ITestListener {

	public void onTestFailure(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println(result.getMethod().getMethodName());
			System.out.println("----Test Has Failed-----");
		}
	}

}
