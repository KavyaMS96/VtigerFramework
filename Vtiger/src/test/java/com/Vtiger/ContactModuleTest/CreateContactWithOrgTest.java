package com.Vtiger.ContactModuleTest;


import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Vtiger.GenericUtility.ExcelUtility;
import com.Vtiger.GenericUtility.FileUtility;
import com.Vtiger.GenericUtility.JavaUtility;
import com.Vtiger.GenericUtility.WebDriverUtility;
import com.Vtiger.POMrepo.ContactsPage;
import com.Vtiger.POMrepo.CreateNewContactPage;
import com.Vtiger.POMrepo.CreateNewOrgPage;
import com.Vtiger.POMrepo.HomePage;
import com.Vtiger.POMrepo.LoginPage;
import com.Vtiger.POMrepo.OrganizationPage;
/**
 * 
 * @author Kavya
 *
 */
public class CreateContactWithOrgTest {
	
	@Test
	public void CreateContactWithOrgTest() throws Throwable {
	
	
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER= fLib.getPropertyData("browser");
		String URL=fLib.getPropertyData("url");
		String Username=fLib.getPropertyData("username");
		String Password=fLib.getPropertyData("password");
	
		WebDriver driver=null;
		
		//step1: Launching Browser
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
		
		//Step2:Login into Application by Entering URL, Username, Password.
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		
		lp.getUsernameTxtBox().sendKeys(Username);
		lp.getPwdTxtbox().sendKeys(Password);	
		lp.getLgnbtn().click();
		
		//Step3: Getting Data from Excel.
		String OrgName = eLib.getExcelData("OrgName", 1, 1) + "_" + jLib.getRandomData();
		String ContactName =eLib.getExcelData("ContactName", 1, 1) + "_" + jLib.getRandomData();
		
		//Step4: Navigating to Organization module
		HomePage hp=new HomePage(driver);
		hp.getOrganization().click();
		
		OrganizationPage org= new OrganizationPage(driver);
		org.getCreateOrganization().click();
		
		CreateNewOrgPage cNeworg= new CreateNewOrgPage(driver);
		cNeworg.getAccountname().sendKeys(OrgName);
		cNeworg.getSave().click();
		String ActualText= org.getActualTitleText().getText();
		
		
		if(ActualText.contains(OrgName)) {
			System.out.println("Organization matched successfully");
		}
		else {
			System.out.println("Organization not matched successfully");
		}
		
		wLib.waitForElementVisibility(driver, hp.getContact());
		
		//step5: Navigate to contact Module
		hp.getContact().click();
		
		//Step6: Navigate to create Contact
		
		CreateNewContactPage cNewCont= new CreateNewContactPage(driver);
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreatecontact().click();
		cNewCont.getLastname().sendKeys(ContactName);
		cNewCont.getCreateOrgname().click();
	
		//Step7: Switch to Child Window
		wLib.switchToWindow(driver, ("Accounts&action"));
		
		cNewCont.getSearchtext().sendKeys(OrgName);
		cNewCont.getSearchnow().click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		
		//Step8: Switch to Parent Window
		wLib.switchToWindow(driver, (" Administrator - Contacts"));
		System.out.println("Switched to parent window");
		cNewCont.getSave().click();
		System.out.println("saved");
		
		System.out.println("Create ContactNameWithOrgTest Executed");
		
		//Step9: Logout
		wLib.mouseHover(driver, hp.getProfImg());
		hp.getSignOutLink().click();
		System.out.println("=====Logout successfull=====");
		
		//Step10: Close the Browser
		driver.close();					
	}
	


}
