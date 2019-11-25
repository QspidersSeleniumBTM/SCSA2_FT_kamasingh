package com.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmLoginPage {
 
	@FindBy(id ="userName")
	private WebElement loginName;

	public WebElement getLoginName() {
		return loginName;
	}

	public void setLoginName(String ln) {
		loginName.sendKeys(ln);
	}
	@FindBy(id="passWord")
	private WebElement passWord;

	public WebElement getPassWord() {
		return passWord;
	}

	public void setPassWord(String pwd) {
		passWord.sendKeys(pwd);
	}
	@FindBy(xpath = "//input[@type='image']")
	private WebElement signIn;

	public WebElement getSignIn() {
		return signIn;
	}

	public void setSignIn(WebElement signIn) {
		signIn.click();
	}

	public void login(String ln, String pwd) {
		loginName.sendKeys(ln);
		passWord.sendKeys(pwd);
		signIn.click();
		
	}
	
	public  CrmLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
