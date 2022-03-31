package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public  WebDriver driver;
	Properties prop;
	public OptionsManager optionsManager;
	public static String highlight;
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(Properties prop) // We pass here Properties class object here just to get the all the value from Properties class. Else we have to write like  public WebDriver init_driver(String url, String browser....)                                                         
	{
		String browserName= prop.getProperty("browser");
	//	highlight=prop.getProperty(highlight).trim();
		
		System.out.println("broser name is: "+browserName);
		optionsManager=new OptionsManager(prop);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
		//	driver=new ChromeDriver(optionsManager.getChromeOptins());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptins()));
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
		//	driver=new FirefoxDriver(optionsManager.getfirefoxOptins());	
			tlDriver.set(new FirefoxDriver(optionsManager.getfirefoxOptins()));
		}
		
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.chromedriver().setup();
			driver=new EdgeDriver();
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
		
	}
	
	public static WebDriver getDriver() {
		
	return	tlDriver.get();
	}
	
	public Properties init_prop() throws IOException {
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\js809\\eclipse-workspace\\POMSeries\\src\\test\\resources\\config\\config.properties");
		prop.load(ip);
		return prop;
	}
	
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
