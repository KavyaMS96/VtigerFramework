package com.Vtiger.OrganizationModuleTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Vtiger.GenericUtility.ExcelUtility;
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
public class CreateOrgName_Industry_TypeTest {
	@Test
	public void CreateOrgName_Industry_TypeTest() throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER= fLib.getPropertyData("browser");
		String URL=fLib.getPropertyData("url");
		String Username=fLib.getPropertyData("username");
		String Password=fLib.getPropertyData("password");
		
		
		
		WebDriver driver=null;
		//Step 1: Launching Browser
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}
		
		wLib.waitUntilPageLoad(driver);
		
		driver.get(URL);
		
		//Step 2: Login into Application
        LoginPage lp=new LoginPage(driver);
		
		lp.getUsernameTxtBox().sendKeys(Username);
		lp.getPwdTxtbox().sendKeys(Password);	
		lp.getLgnbtn().click();
		
		
		
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
			//ex.writeExcelData("OrgName", 1, 4, "PASS");
			
		}
		
		
		else {
			System.out.println("Organization not matched successfully");
			//ex.writeExcelData("OrgName", 1, 4, "FAIL");
			
			
		}
		//step 6: Logout
		wLib.mouseHover(driver,hp.getProfImg());
		hp.getSignOutLink().click();
		System.out.println("=====Logout successfull=====");
		
		//Step 7: Close Browser
		driver.close();
		
	}
	
	

}
