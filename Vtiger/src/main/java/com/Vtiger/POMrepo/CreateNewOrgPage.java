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
public class CreateNewOrgPage {
	/**
	 * constructor
	 * @param driver
	 */
	public CreateNewOrgPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//input[@name=\"accountname\"]")
	private WebElement accountname;
	
	@FindBy(xpath="//select[@name=\"industry\"]")
	private WebElement industry;
	
	@FindBy(xpath="//select[@name=\"accounttype\"]")
	private WebElement type;
	
	@FindBy(xpath ="//input[@title=\"Save [Alt+S]\"]")
	private WebElement save;
	
	public WebElement getAccountname() {
		return accountname;
	}
	
	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getType() {
		return type;
	}
	
	public WebElement getSave() {
		return save;
	}

	

}
