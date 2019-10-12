package com.qa.hubspot.PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;

public class LoginPage extends BasePage{
	WebDriver driver;
	
	//1. We create Object Repositories/page objects Using By locator
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
//	By donthaveaccount = By.xpath("//div[@class='signup-link']/i18n-string");
//	By showPassword = By.xpath("//span[@id='password-help']//span");
	
	//2.Create constructor 
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3.page actions/Methods
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage doLogin(String username,String pwd) {
		driver.findElement(emailId).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new HomePage(driver);
	}
	
	public boolean signUpLinkIsDisplayed() {
		return driver.findElement(signUpLink).isDisplayed();
	}

	
}
