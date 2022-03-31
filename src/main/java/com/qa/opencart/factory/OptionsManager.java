package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	
	 public OptionsManager(Properties prop) {
		
	 
		this.prop=prop;
		
	}
	
	public ChromeOptions getChromeOptins () {
	 co=new ChromeOptions();
	 
	 
	 if (Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");	// Boolean.parseBoolean will convert string to boolen	 
	 if(Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incoginto");
	 return co;
	}

	public FirefoxOptions getfirefoxOptins () {
		 fo=new FirefoxOptions();
		 
		 
		 if (Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");		 
		 if(Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incoginto");
		 
		 return fo;
		}
}
