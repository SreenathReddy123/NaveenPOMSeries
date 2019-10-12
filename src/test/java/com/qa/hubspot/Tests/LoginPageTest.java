package com.qa.hubspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.PageLayer.LoginPage;
import com.qa.hubspot.Util.Constants_Util;

public class LoginPageTest {

	
	BasePage basePage;
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_Properties();
		driver = basePage.init_Driver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("The loginpage title is "+title);
		Assert.assertEquals(title, Constants_Util.login_page_title);
	}
	
	@Test(priority=2)
	public void signUpLinkTest() {
		Assert.assertTrue(loginPage.signUpLinkIsDisplayed());
	}
	
	@Test(priority =3)
	public void doLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
