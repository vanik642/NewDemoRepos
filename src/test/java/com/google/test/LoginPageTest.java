package com.google.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.basetest.BaseTest;


public class LoginPageTest extends BaseTest {
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actPageTitle=loginPage.getloginPageTitle();
		//Assert.assertEquals(actPageTitle, "Facebook - log in or sign up");
	}
	
//	@Test(priority = 2)
//	public void loginPageURLTest() {
//		String actPageUrl=loginPage.getloginPageURL();
//		Assert.assertEquals(actPageUrl, "https://www.facebook.com/");
//		
//	}
//	
	//@Test
//	public void loginPageSearchItem() {
//	    loginPage.searchItem();
//		
//		
//	}
	
//	@Test(priority = 3)
//	public void loginPageURLTest1() {
//		
//		loginPage.clickFaceBookLite();
//		
//	}


}
