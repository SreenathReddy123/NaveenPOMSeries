package com.qa.hubspot.PageLayer;

import org.openqa.selenium.WebDriver;

public class DealsPage {
	WebDriver driver;
	
	public DealsPage(WebDriver driver) {
		this.driver=driver;
	}

	public String getTitle() {
		System.out.println("Deals Page");
		return driver.getTitle();
	}
	
}
