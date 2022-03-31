package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductInfoTest extends BaseTest{
	
	@BeforeClass
	public void productInfoSetup() {
	loginPage.doLogin(prop.getProperty("userName"), prop.getProperty("password"));
	
	}
    @Test
    public void productHeaderTest() {
    	resultpage=accPage.doSearch("Macbook");
    	resultpage.selectProduct("MacBook Pro");
    	Assert.assertEquals(productinfopage.getProductHeaderName(), "MacBook Pro");
    }
    
    @Test
    public void productImgCount() {
    	resultpage=accPage.doSearch("Macbook");
    	resultpage.selectProduct("MacBook Pro");
    	int imagesCount=productinfopage.getProductImageCount();
    	System.out.println("Total image for "+ "MacBook Pro" +":"+imagesCount);
    	Assert.assertEquals(imagesCount, 4);
    }
    
    
    @Test
    public void productDataTest() {
    	resultpage=accPage.doSearch("Macbook");
    	productinfopage=resultpage.selectProduct("MacBook Pro");
    	Map<String, String>actProductInfoMap=productinfopage.getProductInfo();
    	actProductInfoMap.forEach((k,v)->System.out.println(k+":"+v));
    	softAssert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
    	softAssert.assertEquals(actProductInfoMap.get("name"), "MacBook Pro");
    	softAssert.assertEquals(actProductInfoMap.get("Product code"), "Product 18");
    	softAssert.assertAll(); 	
    	
    	
    }
}
