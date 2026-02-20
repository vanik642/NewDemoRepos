package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FaceBookLite {
	
	private WebDriver driver;

	
	//1.private By locators
	private final By searchBox=By.name("q");
	private final By videoLink=By.xpath("//a[@title=\"Browse in Video\"]");

	
	public FaceBookLite(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String getfbLitePageTitle() {
		String faceBookLiteTitle=driver.getTitle();
		System.out.println("FaceBook Lite:"+faceBookLiteTitle);
		return faceBookLiteTitle;
	}
	
	public String getfbLitePageURL() {
		String faceBookLiteURL=driver.getCurrentUrl();
		System.out.println("FaceBookLite URL :"+faceBookLiteURL);
		return faceBookLiteURL;
	}
	
	public FaceBookLiteVideo clickOnVideoLink() {
		driver.findElement(videoLink).click();
		return new FaceBookLiteVideo(driver);
		
	}
	

}
