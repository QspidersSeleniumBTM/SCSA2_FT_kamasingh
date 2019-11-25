package com.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaign {
	public  CreateCampaign(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[.='Campaigns']")
	private WebElement campaign;

	public WebElement getCampaign() {
		return campaign;
	}

	public void clickCampaignTab() {
		campaign.click();
		
	}

	
}
