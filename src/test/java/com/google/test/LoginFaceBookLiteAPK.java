package com.google.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.basetest.BaseTest;

public class LoginFaceBookLiteAPK extends BaseTest {

	@BeforeClass

	public void fbLitePageSetup() {
		fbLite = loginPage.clickFaceBookLite();

	}

	@Test

	public void fbLitePageTitleTest() {
		String fbPageTItle = fbLite.getfbLitePageTitle();
		System.out.println("titlee: " + fbPageTItle);
		// Assert.assertEquals(actPageTitle, "Google");
	}

	public void fbLitePageTitleURl() {
		String fbPageTItleURL = fbLite.getfbLitePageURL();
		System.out.println("titlee: " + fbPageTItleURL);
		// Assert.assertEquals(actPageTitle, "Google");
	}

}
