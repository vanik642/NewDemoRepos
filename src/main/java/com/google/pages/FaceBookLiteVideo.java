package com.google.pages;

import org.openqa.selenium.WebDriver;

public class FaceBookLiteVideo {

	private WebDriver driver;
	
	public FaceBookLiteVideo(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String getfbLiteVideoPageTitle() {
		String faceBookLiteTitle=driver.getTitle();
		System.out.println("FaceBook Lite Video Title:"+faceBookLiteTitle);
		return faceBookLiteTitle;
	}
	
	public String getfbLiteVideoPageURL() {
		String faceBookLiteURL=driver.getCurrentUrl();
		System.out.println("FaceBookLite VIdeo URL :"+faceBookLiteURL);
		return faceBookLiteURL;
	}
}
