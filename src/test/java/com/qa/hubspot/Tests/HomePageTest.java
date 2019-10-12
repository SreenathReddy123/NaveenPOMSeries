package com.qa.hubspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.PageLayer.HomePage;
import com.qa.hubspot.PageLayer.LoginPage;
import com.qa.hubspot.Util.Constants_Util;

public class HomePageTest {
	

	BasePage basePage;
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_Properties();
		driver = basePage.init_Driver(prop);
		loginPage = new LoginPage(driver);
		homePage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void homePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("The home page title is "+title);
		Assert.assertEquals(title, Constants_Util.home_page_title);
	}
	
	@Test(priority=2)
	public void homePageHeaderTest() {
		Assert.assertTrue(homePage.isHomePageHeaderVisible());
		
		String headerText = homePage.getHomePageHeaderText();
		System.out.println("The header text is "+headerText);
	}
	
	@Test(priority=3)
	public void accountnameVisibilityTest() {
		Assert.assertTrue(homePage.isHomePageuserAccountVisible());
		
		String userName = homePage.getHomePageuserAccountText();
		System.out.println("the username is "+userName);
		Assert.assertEquals(userName, prop.getProperty("accountname"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
