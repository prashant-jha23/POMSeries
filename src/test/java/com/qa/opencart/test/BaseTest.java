package com.qa.opencart.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	AccountPage accPage;
	ResultsPage resultpage;
	ProductInfoPage productinfopage;
	SoftAssert softAssert; // because there is no static method in the Softassert class hence we have to create refrence veriable 
		
	
	@BeforeTest
	public void setUp() throws Exception   {
		df=new DriverFactory();
		prop=df.init_prop();
		driver= df.init_driver(prop);
		loginPage=new LoginPage(driver);
		accPage=new AccountPage(driver);
		productinfopage=new ProductInfoPage(driver);
		softAssert=new SoftAssert();
		
	}
	
	@AfterTest()
	public void tearDown()
	{
		driver.quit();
	}
}
