package com.Vtiger.OrganizationModuleTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RetryAnalyserCreateOrg {
	@Test(retryAnalyzer=com.Vtiger.GenericUtility.RetryAnalyser.class )
	
	public void createOrg() {
		Reporter.log("This is Created Org", true);
		Assert.fail();
	}

}

