package com.qa.hubspot.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author sreenath
 *
 */
public class BasePage {
	WebDriver driver;
	Properties prop;
	
	/**
	 * This method is used to initialize the driver based on the value of browser
	 * @param prop
	 * @return driver
	 */
	public WebDriver init_Driver(Properties prop) {
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Please check the browser value ...");
		}
		
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(url);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver;
	}
	/**
	 * This method is used to get the properties from the config prop files
	 * @return prop
	 */
	public Properties init_Properties() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\sreenath.Sreenath-Pc\\eclipse-workspace\\NaveenPOMSeries\\"
					+ "src\\main\\java\\com\\qa\\hubsot\\Config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
}
