package com.qa.hubspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.PageLayer.ContactsPage;
import com.qa.hubspot.PageLayer.HomePage;
import com.qa.hubspot.PageLayer.LoginPage;
import com.qa.hubspot.Util.Constants_Util;
import com.qa.hubspot.Util.ExcelUtil;

public class ContactsPageTest {
	BasePage basePage;
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_Properties();
		driver = basePage.init_Driver(prop);
		loginPage = new LoginPage(driver);
		homePage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.gotoContactsPage();
	}
	
	@Test(priority=1)
	public void getTitleTest() {
		String title =driver.getTitle();
		System.out.println("The title of contacts page is "+title);
		Assert.assertEquals(title, Constants_Util.contacts_page_title);
	}
	
	
	@Test(priority=2)
	public void contactHeaderVisibleTest() {
		Assert.assertTrue(contactsPage.isHeaderVisible());
		
		String header = contactsPage.getHeaderText();
		System.out.println("The header of contacts page is "+header);
		Assert.assertEquals(header, Constants_Util.contacts_page_title);
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = ExcelUtil.getTestData("contacts");
		return data;
	}
	
	@Test(priority=3,dataProvider="getTestData")
	public void createContactTest(String emailId,String firstName,String lastName,String jobTitle) {
		contactsPage.createNewContact(emailId,firstName,lastName,jobTitle);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
