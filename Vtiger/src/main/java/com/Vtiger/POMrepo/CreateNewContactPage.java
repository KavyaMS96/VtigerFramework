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
public class CreateNewContactPage {
	/**
	 * constructor
	 * @param driver
	 */

	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement CreateOrgname;
	
	
	@FindBy(name="search_text")
	private WebElement searchtext;
	
	@FindBy(name="search")
	private WebElement searchnow;
	
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement save;


	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getCreateOrgname() {
		return CreateOrgname;
	}

	public WebElement getSearchtext() {
		return searchtext;
	}

	public WebElement getSearchnow() {
		return searchnow;
	}


	public WebElement getSave() {
		return save;
	}
	
	

}
