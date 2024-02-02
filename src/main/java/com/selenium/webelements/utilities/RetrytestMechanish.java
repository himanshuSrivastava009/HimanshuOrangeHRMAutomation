package com.selenium.webelements.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetrytestMechanish implements IRetryAnalyzer{

	private final int MAX_retry_Count = 3;
	private int count = 0;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(!result.isSuccess()) {
			count++;
			if(count<MAX_retry_Count) {
				return true;
			}
			
		}
		
		return false;
	}
		

	
}
