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
public class ContactsPage {
	/**
	 * constructor class
	 * @param driver
	 */
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createcontact;
	
	public WebElement getCreatecontact() {
		return createcontact;
	}
	

}
