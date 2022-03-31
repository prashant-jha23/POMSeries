package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Consants;
import com.qa.opencart.util.ElementUtils;

public class LoginPage {
	
	//Private By locator 
	private WebDriver driver;
	ElementUtils elementutil;
	
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By forgotPWDlink = By.linkText("Forgotten Password");
	private By forgotPWD=By.xpath("//div[@class='form-group']/a");
	private By registerlink=By.linkText("Register");
	
	
	// Page Constructor:
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		elementutil=new ElementUtils(driver);
	}
	
	//public page actions methods:
	public String getTittle() {
		return elementutil.doGetPageTitlesIs(Consants.LOGIN_PAGE_TITLE, Consants.TIME_OUT);
	}
    public String getLoginPageURL() {
    	return elementutil.waitForUrlContains(Consants.LOGIN_PAGE_URL, Consants.TIME_OUT);
    }
    
    
    public boolean isForgotPwdLinkExist() {
    	return driver.findElement(forgotPWD).isDisplayed();
    }
    
    public AccountPage doLogin(String UserName, String pwd) {
    	elementutil.doSendKeys(emailId, UserName);
    	elementutil.doSendKeys(password, pwd);
    	//driver.findElement(emailId).sendKeys(UserName);
    	//driver.findElement(password).sendKeys(pwd);
    	driver.findElement(loginBtn).click();
    	return new AccountPage(driver);
    	
    }
}
