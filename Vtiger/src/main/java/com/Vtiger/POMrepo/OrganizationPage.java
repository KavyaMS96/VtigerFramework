package com.Vtiger.POMrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Kavya
 *
 */
public class OrganizationPage {
	/**
	 * constructor Class
	 * @param driver
	 */
	
	public OrganizationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//img[@title='Create Organization...']")
	private WebElement createOrganization;
	
	
	
	
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ActualTitleText;
	
	
	public WebElement getActualTitleText() {
		return ActualTitleText;
	}

	public WebElement getCreateOrganization() {
		return createOrganization;
	}

	
	
	
}
