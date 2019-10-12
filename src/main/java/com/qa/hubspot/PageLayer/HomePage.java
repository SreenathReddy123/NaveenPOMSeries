package com.qa.hubspot.PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;

public class HomePage extends BasePage{
	
	WebDriver driver;
	//Object Repositories 
	
	By salesDashboard = By.xpath("//h1[text()='Sales Dashboard']");
	By clickAccount = By.xpath("//a[@id='account-menu']");
	By userAccountName = By.xpath("//div[text()='Greetel ']");
	By clickContactBtn = By.xpath("(//a[@id='nav-primary-contacts-branch'])[1]");
	By clickContact    = By.xpath("(//a[@id='nav-secondary-contacts'])[1]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	//Actions /Methods 	
	public String getHomePageTitle() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.getTitle();
	}
	
	public boolean isHomePageHeaderVisible() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.findElement(salesDashboard).isDisplayed();
	}

	public String getHomePageHeaderText() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.findElement(salesDashboard).getText();
	}
	
	public void clickHomePageAccount() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(clickAccount).click();
	}
	
	public boolean isHomePageuserAccountVisible() {
		
		clickHomePageAccount();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.findElement(userAccountName).isDisplayed();
	}

	public String getHomePageuserAccountText() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.findElement(userAccountName).getText();
	}
	
	public ContactsPage gotoContactsPage() {
		clickHomePageContact();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(clickContact).click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ContactsPage(driver);
		
	}
	
	private void clickHomePageContact() {
		driver.findElement(clickContactBtn).click();
	}
	
}
