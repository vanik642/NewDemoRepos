package com.google.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.google.factory.DriverFactory;

import com.google.pages.FaceBookLite;
import com.google.pages.FaceBookLiteVideo;
import com.google.pages.LoginPage;


public class BaseTest {
	
	WebDriver driver;
	DriverFactory df;
	Properties prop;
	protected LoginPage loginPage;
	protected FaceBookLiteVideo fbLiteVideo;
	protected FaceBookLite fbLite;
	
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserNam) {
		df=new DriverFactory();
		prop=df.initProp();
		//driver=df.initDriver(prop);
		
		
		//browserNam is apssed from .xml
		if(browserNam!=null) {
			prop.setProperty("browser", browserNam);
		}
		driver=df.initDriver(prop);//login Page
		loginPage=new LoginPage(driver);
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
