package com.qa.opencart.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.factory.DriverFactory;

import io.netty.handler.timeout.TimeoutException;

public class ElementUtils {
	
private WebDriver driver;
private JavaScriptUtil jsUtil;

	public ElementUtils(WebDriver driver) {
		this.driver=driver;
		jsUtil=new JavaScriptUtil(driver);
	}
	
	public WebElement getElement(By locator) {
		
	WebElement ele= driver.findElement(locator);
//	if (Boolean.parseBoolean(DriverFactory.highlight)) {
//		jsUtil.flash(ele);
//		
//	}
	return ele;	
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public void doSendKeys(By locator, String value)
	{
		WebElement ele=getElement(locator);
		ele.clear();
		getElement(locator).sendKeys(value);
	}
	
	public  void doClick(By locator) 
	{
		getElement(locator).click();
	}

	public void browserClose() {
		driver.close();
	}
	
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
		
	}
	
	
	
	//*******Wait utill concept 14th lecture********
	
//	public static WebElement getElement(By locator) {
//		return driver.findElement(locator);
//		
//	}
	public WebElement waitForElementPresence(By locator, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	public List<WebElement> waitForElementsVisible(By locator, int timeout){
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	
	
	// non web elements:: title, url, alert
	
	public boolean waitForPageTitle(String titleVal, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.titleIs(titleVal));
	}
	
	
	public boolean waitForPageActTitle(String actTitle, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.titleIs(actTitle));
	}
	
	
	public String doGetPageTitleContains(String titleVal, int timeout) {
		if(waitForPageActTitle(titleVal, timeout)) {
			return driver.getTitle();
		}return null;
	}
	
	
	public String doGetPageTitlesIs(String titleVal, int timeout) {
		if(waitForPageActTitle(titleVal, timeout)) {
			return driver.getTitle();
		}
		return null;

}
	public String waitForUrlContains(String urlFraction, int timeout) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		try {
			if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
				return driver.getCurrentUrl();
			}
		}catch(TimeoutException e) {
			return null;
		}
		return null;
	}
	
	}
