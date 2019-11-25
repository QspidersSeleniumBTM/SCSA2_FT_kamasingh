package com.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaign {

	@FindBy(xpath = "//input[@class='button' and @value='New Campaign']")
	private   WebElement newCampaign;

	public WebElement getNewCampaign() {
		return newCampaign;
	}

	public void clickNewCampaign() {
		newCampaign.click();
	}
	public  CreateNewCampaign(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	
	
}
