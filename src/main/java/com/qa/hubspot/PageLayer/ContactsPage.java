package com.qa.hubspot.PageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;

public class ContactsPage extends BasePage{ 

	WebDriver driver;
	
	By header = By.xpath("//i18n-string[text()='Contacts']");
	By createContact = By.xpath("//span[text()='Create contact']/ancestor::button");
	By emailId = By.name("textInput");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName =  By.xpath("//input[@data-field='lastname']");
	By jobTitle =  By.xpath("//input[@data-field='jobtitle']");
	By clickOnCrtContact = By.xpath("//div[text()='Create contact']/parent::button");
		
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isHeaderVisible() {
		return driver.findElement(header).isDisplayed();
	}
	
	public String getHeaderText() {
		return driver.findElement(header).getText();
	}
	
	public void createNewContact(String email,String Fn,String LN,String jbTitle) {
		driver.findElement(createContact).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(emailId).sendKeys(email);
		driver.findElement(firstName).sendKeys(Fn);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(lastName).sendKeys(LN);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(jobTitle).sendKeys(jbTitle);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(clickOnCrtContact).click();
	}
	
	
}
