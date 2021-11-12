package com.Vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class will implement retry analyzer which can be utilize for failed test scripts
 * @author Kavya
 *
 */
public class RetryAnalyser implements IRetryAnalyzer {

	int count=0;
	int retryCount=4;
	
	public boolean retry(ITestResult result) {
		while(count<retryCount) {
			count++;
			return true;
		}
		return false;
	}

}
