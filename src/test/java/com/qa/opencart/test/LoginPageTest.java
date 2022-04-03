package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.util.Consants;

import bsh.org.objectweb.asm.Constants;
import io.qameta.allure.Description;

public class LoginPageTest extends BaseTest
{
	
	@Description("Login page test")
	@Test(priority =1)
	public void loginPageTest() {
		String title=loginPage.getLoginPageURL();
		System.out.println("Login Page tittle :"+title);
		Assert.assertEquals(title, Consants.LOGIN_PAGE_TITLE);
	}
	@Description("TC_01 Login page url test")
	@Test(priority=2)
	public void loginPageURLTest() {
		String url=loginPage.getLoginPageURL();
		Assert.assertTrue(url.contains("account/login"));
	}
    @Test(priority=3)
    public void verifyForgotPwdLink()
    {
    	Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }
    @Test(priority=4)
    public void loginTest() throws InterruptedException {
    	accPage =loginPage.doLogin(prop.getProperty("userName"),prop.getProperty("password"));
    	Assert.assertTrue(accPage.isLogoutlinkExist());
    	Thread.sleep(2000);
    }
}
