package com.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZohoCRMHomePage {
	
	@FindBy(xpath = "//a[@class='topLink' and @href='/crm/logout.sas']")
	private WebElement logOut;

	public WebElement getLogOut() {
		return logOut;
	}

	public void clickLogOut() {
		logOut.click();
	}

	public ZohoCRMHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
