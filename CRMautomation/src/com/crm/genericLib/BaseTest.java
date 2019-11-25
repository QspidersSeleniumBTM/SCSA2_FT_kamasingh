package com.crm.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.pages.CrmLoginPage;

public abstract class BaseTest implements IAutoConts{

	public static WebDriver driver;
	FileLibrary flib;
	WebdriverCommonLib wlib;
	
	
	@BeforeClass
	public void openBrowser() throws Throwable
	{
		flib=new FileLibrary();
		wlib=new WebdriverCommonLib();
		String browserValue = flib.getKeyPropValue(PROPERTY_PATH, "browser");
		if(browserValue.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver=new ChromeDriver();
		} 
		
		else if(browserValue.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver=new FirefoxDriver();
		}
		else
		{
			Reporter.log("Enter Correct Browser Name",true);
		}
		
		String url = flib.getKeyPropValue(PROPERTY_PATH, "url");
		driver.get(url);
		
		String expectedTitle = flib.getCellData(EXCEL_PATH, "Sheet3", 1, 4);
		Reporter.log(expectedTitle,true);
		
		wlib.verifyAssert(wlib.getPageTitle(), expectedTitle, "Login Page");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void loginToApp() throws Throwable
	{
		flib=new FileLibrary();
		wlib=new WebdriverCommonLib();
		
		String username = flib.getKeyPropValue(PROPERTY_PATH, "username");
		String password = flib.getKeyPropValue(PROPERTY_PATH, "password");
		    CrmLoginPage alp = new CrmLoginPage(driver);
		alp.login(username, password);
		String expectedHomeTitle = flib.getCellData(EXCEL_PATH, "Sheet3", 1, 5);
		wlib.verifyAssert(wlib.getPageTitle(), expectedHomeTitle, "Home Page");
	}
}
	
	