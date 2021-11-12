package com.Vtiger.OrganizationModuleTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.Vtiger.GenericUtility.BaseClass;
import com.Vtiger.GenericUtility.FileUtility;
import com.Vtiger.GenericUtility.JavaUtility;
import com.Vtiger.GenericUtility.WebDriverUtility;
import com.Vtiger.POMrepo.CreateNewOrgPage;
import com.Vtiger.POMrepo.HomePage;
import com.Vtiger.POMrepo.LoginPage;
import com.Vtiger.POMrepo.OrganizationPage;
/**
 * 
 * @author Kavya
 *
 */
public class CreateOrgNameTest extends BaseClass {
	
	@Test
	public void CreateOrgNameTest() throws Throwable {

		String OrgName = eLib.getExcelData("OrgName", 1, 1) + "_" + jLib.getRandomData();
		//Step 3: Navigate to Organization module.
		HomePage hp=new HomePage(driver);
		hp.getOrganization().click();
		
		OrganizationPage org= new OrganizationPage(driver);
		org.getCreateOrganization().click();
		//Step 4: Navigate to CreateNewOrgPage
		CreateNewOrgPage cNeworg= new CreateNewOrgPage(driver);
		cNeworg.getAccountname().sendKeys(OrgName);
		cNeworg.getSave().click();
		
		//Step 5: VerifyZ
		String ActualText= org.getActualTitleText().getText();
		
		if(ActualText.contains(OrgName)) {
			System.out.println("Organization matched successfully");
			//eLib.writeExcelData("OrgName", 1, 4, "PASS");
		}
		else {
			System.out.println("Organization not matched successfully");
		}
		System.out.println("Create OrgNameTest Executed");
	}
	
	
	
	@Test
	public void CreateOrgNameWithIndustryWithType() throws Throwable {
		String OrgName = eLib.getExcelData("OrgName", 1, 1)+ "_" + jLib.getRandomData();
		String IndName = eLib.getExcelData("OrgName", 1, 2);
		String Type = eLib.getExcelData("OrgName", 1, 3);
		
		//Step 3: Navigate to Organization module
		HomePage hp=new HomePage(driver);
		hp.getOrganization().click();
	
		OrganizationPage org= new OrganizationPage(driver);
		org.getCreateOrganization().click();
		
		//Step 4: Navigate to CreateNewOrg page.
		CreateNewOrgPage cNeworg= new CreateNewOrgPage(driver);
		cNeworg.getAccountname().sendKeys(OrgName);
		
		wLib.SelectOption(cNeworg.getIndustry(),IndName);
		wLib.SelectOption(cNeworg.getType(),Type);
		
		cNeworg.getSave().click();
		
		String ActualText= org.getActualTitleText().getText();
		//Step 5: Verify
		if(ActualText.contains(OrgName)) {
			System.out.println("Organization matched successfully");
		}

		else {
			System.out.println("Organization not matched successfully");
		}
		
		System.out.println("Create OrgNameWithIndustryWithTypeTest Executed");
	}

}
