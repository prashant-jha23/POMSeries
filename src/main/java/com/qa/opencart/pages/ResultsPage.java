package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Consants;
import com.qa.opencart.util.ElementUtils;

public class ResultsPage {
	
	private WebDriver driver;
	private ElementUtils elementutils;
	
	private By searchHeader =By.xpath("//div[@id='content']/h1");
	private By productResult=By.xpath("//div[@class='product-thumb']/div[2]/div/h4/a");
	
	public ResultsPage(WebDriver driver)
	{
		this.driver=driver;
		elementutils=new ElementUtils(driver);
	}

	public int getProductListCount() 
	{
		int productCount= elementutils.waitForElementsVisible(productResult, Consants.TIME_OUT).size();
		System.out.println("Total search count "+productCount);
		return productCount;
	}
	
	
	public ProductInfoPage selectProduct(String mainProductName) {
		System.out.println("Main Serch product name is: "+ mainProductName);
	    List<WebElement> searchList=elementutils.waitForElementsVisible(productResult, 10);
	    for(WebElement e:searchList) {
	    	String text=e.getText();
	    //	System.out.println(e);
	    	if (text.equals(mainProductName)) {
	    		
	    		e.click();
	    		break;
	    	}
	    	
	    	 
	    }
	    
	    return new ProductInfoPage(driver);   
	     
	}
	
	
	
}
