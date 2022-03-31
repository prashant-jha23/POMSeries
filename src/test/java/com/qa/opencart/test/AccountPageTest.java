package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.util.Consants;

public class AccountPageTest extends BaseTest
{
	@BeforeClass
	public void accPageSetup() {
		accPage= loginPage.doLogin(prop.getProperty("userName"), prop.getProperty("password"));
	}
    
//	@Test
	public void accPageTitleTest() {
		String actTitle=accPage.getAccountPageTittle();
	//	System.out.println("Acc page title: "+actTitle);
		Assert.assertEquals(actTitle, Consants.ACCOUNT_PAGE_TITTLE);
	}
//	@Test
	public void accPageUrlTest() {
		String acturl=accPage.getAccouctPageURL();
	//	System.out.println("Acc page url: "+ acturl);
		Assert.assertTrue(acturl.contains(Consants.ACCOUNT_PAGE_URL_FRACTION));
	}
	
//	@Test
	public void accPageHeaderTest() {
		String header=accPage.getPageheader();
	//	System.out.println("Account page header: "+header);
		Assert.assertEquals(header, Consants.ACCOUNT_PAGE_HEADER);
	}
//	@Test
	public void logoutLinkTest() throws InterruptedException {
	//	accPage.logout();
		Thread.sleep(3000);
		Assert.assertTrue(accPage.logout());
	}
//	@Test
	public void searchExistTest() {
		Assert.assertTrue(accPage.searchExist());
	}
	@Test
	public void accPageSectionsTest() {
		List<String> accSections=accPage.getAccPageSections();
		System.out.println("actual sec list: "+accSections);
		Assert.assertEquals(accSections, Consants.ACCOUNTS_PAGE_SECTIONS_LIST);
	}
	
	@DataProvider
	public Object [][] productData(){ // This is data provider
		
		return new Object[][] {
			{"Macbook"},
			{"iMac"},
			{"Apple"}
			
		};
	}
 // ProductInfoPAge @test method writing here 
//	@Test(dataProvider = "productData")
	public void searchTest(String productName) throws InterruptedException {
		resultpage=accPage.doSearch(productName);
		Assert.assertTrue(resultpage.getProductListCount()>0);
	
	}
	@Test
	public void selectProduct() throws InterruptedException {
		resultpage =accPage.doSearch("MacBook");
		Thread.sleep(3000);
		productinfopage =resultpage.selectProduct("MacBook Pro");
		Thread.sleep(3000);
		Assert.assertEquals(productinfopage.getProductHeaderName(),"MacBook Pro");
	}
	
	
}
