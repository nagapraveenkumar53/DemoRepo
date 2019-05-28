package com.orangehrm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserUtils {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static void initializeDriver() throws IOException{
		prop=new Properties();
		FileInputStream fip=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/orangehrm/config/config.properties"); 
		prop.load(fip);
		
		switch(prop.getProperty("browser"))
		{
		case "chrome" :
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver_new.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
			
		case "firefox" :
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "ie" :
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;
			
		default :
			System.out.println("Invalid Browser type");
			break;
		}
	}
	
	
	

}
