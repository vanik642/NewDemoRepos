package com.google.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.basetest.BaseTest;

public class LoginFaceBookVideo extends BaseTest{
	
	@BeforeClass

	public void fbLitePageSetup() {
		fbLite = loginPage.clickFaceBookLite();

	}

	@Test
	public void fbLitVideoPageTitle() {
		fbLiteVideo=fbLite.clickOnVideoLink();
		String fbVideoTitleVideo=fbLiteVideo.getfbLiteVideoPageTitle();
		System.out.println("fbVideoTitleVideo---->"+fbVideoTitleVideo);
		
	}


}
