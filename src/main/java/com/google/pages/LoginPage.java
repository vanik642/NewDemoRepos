package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.util.ElementUtil;
import com.google.util.JavaScriptUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;

	
	//1.private By locators
	private final By searchBox=By.name("q");
	private final By fbLite=By.xpath("//a[@title='Facebook Lite for Android.']");

	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		jsUtil=new JavaScriptUtil(driver);
		eleUtil=new ElementUtil(driver);
		
	}
	
	public String getloginPageTitle() {
		String faceBookTitle=driver.getTitle();
		System.out.println("faceBookTitle :"+faceBookTitle);
		return faceBookTitle;
	}
	
	public String getloginPageURL() {
		String faceBookURL=driver.getCurrentUrl();
		System.out.println("faceBookURL :"+faceBookURL);
		return faceBookURL;
	}
	
//	public SearchPage searchItem() {
//	    driver.findElement(searchBox).sendKeys("Playwright");
//	    driver.findElement(searchBox).sendKeys(Keys.ENTER);
//	    return new SearchPage(driver);
//	    
//		
//	}
//	
	public FaceBookLite clickFaceBookLite() {
		eleUtil.clickWhenReady(fbLite,2000);
	   
	    return new FaceBookLite(driver);
	    
		
	}
	
	
	

		
		
		
	
}
