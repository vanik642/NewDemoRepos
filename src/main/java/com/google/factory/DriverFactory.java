package com.google.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.exception.BrowserException;
import com.google.exception.FrameworkException;

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	//public WebDriver initDriver(String browserName) {
		
		public WebDriver initDriver(Properties prop) 
		{
			String browserName=prop.getProperty("browser");
			optionsManager=new OptionsManager(prop);
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			if(Boolean.parseBoolean(prop.getProperty("remote")) ){
				try {
					driver=new RemoteWebDriver(new URL(prop.getProperty("huburl")),optionsManager.getChromeOptions());
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				driver=new ChromeDriver(optionsManager.getChromeOptions());
				
				
			}
			break;
			
		case "firefox":
			driver=new FirefoxDriver(optionsManager.getFirefoxOptions());
			break;

		default:
			System.out.println("PLease pass the valid browser.."+browserName);
			throw new BrowserException("INVALID BROWSER");
			
		}
		
		//driver.get("https://www.google.com/");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		return driver;
		
	}
		// mvn clean install -Denv="stage"
		public Properties initProp() {
		String envName = System.getProperty("env"); // command line variable env
		System.out.println("Running tests on env :" + envName);
		FileInputStream ip = null;
		prop = new Properties();

		try {
			if (envName == null) {
				//log.warn("env is null ,hence running the testes on QA env...");

				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
			} else {
				//log.info("Running tests on env..." + envName);
				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;
				case "uat":
					ip = new FileInputStream("./src/test/resources/config/uat.config.properties");
					break;
				case "prod":
					ip = new FileInputStream("./src/test/resources/config/prod.config.properties");
					break;

				default:
					//log.error("----invalid env name----" + envName);
					throw new FrameworkException("===INVALID ENV NAME===" + envName);

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(ip);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}


}
