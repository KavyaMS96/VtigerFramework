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
public class HomePage {
	/**
	 * constructor
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//img[@style='padding: 0px;padding-left:5px'])[1]")
	private WebElement profImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	@FindBy(xpath ="(//a[text()=\"Organizations\"])[1]")
	private WebElement organization;
	
	@FindBy(linkText = "Contacts")
	private WebElement contact;
	
	

		public WebElement getProfImg() {
		return profImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getContact() {
		return contact;
	}
	
	

	
	

}
