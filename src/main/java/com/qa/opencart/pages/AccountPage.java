package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Consants;
import com.qa.opencart.util.ElementUtils;

public class AccountPage {
	
	WebDriver driver;
	ElementUtils elementutils;
	private By header=By.xpath("//div[@id='logo']/h1/a");
	private By sections=By.xpath("//div[@id='content']/h2");
	//private By logout =By.linkText("logout");
	private By logout=By.xpath("//div[@class='list-group']/a[13]");
	private By search =By.name("search");
	private By searchIcon =By.xpath("//div[@id='search']/span/button");
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		elementutils=new ElementUtils(driver);		
	}
	
	public String getAccountPageTittle(){
		String actualTittle=elementutils.doGetPageTitlesIs(Consants.ACCOUNT_PAGE_TITTLE, 10);
		return actualTittle;
	}
    public String getAccouctPageURL() {
    	return elementutils.waitForUrlContains(Consants.ACCOUNT_PAGE_URL_FRACTION, Consants.TIME_OUT);
    }
	
    public String getPageheader() {
    	return elementutils.doGetText(header);
    	
    }
    public Boolean isLogoutlinkExist() {
    	return elementutils.doIsDisplayed(logout);
    }
    
    public boolean logout() {
    	if(isLogoutlinkExist()) {
    		elementutils.doClick(logout);
    		return true;
    	}
    	return false;   
    }
    public List<String> getAccPageSections() {
    	List<WebElement> sectionsList=elementutils.waitForElementsVisible(sections, Consants.TIME_OUT);
    	List<String>arraylist=new ArrayList<String>();
    	for(WebElement e:sectionsList)
    	{
    		String value=e.getText();
    		arraylist.add(value);
    	}
    	return arraylist;
    }
    
    public boolean searchExist() {
    	return elementutils.doIsDisplayed(search);
    }
    
    public ResultsPage doSearch(String productName)
    {
    	if(searchExist()) {
    		elementutils.doSendKeys(search, productName);
    		elementutils.doClick(searchIcon);
    	}
    	return new ResultsPage(driver);
    }
}
