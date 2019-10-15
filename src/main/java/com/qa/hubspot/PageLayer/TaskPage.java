package com.qa.hubspot.PageLayer;

import org.openqa.selenium.WebDriver;

public class TaskPage {

WebDriver driver;
	
	public TaskPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void doTask() {
		System.out.println("Create a Task");
	}
	
	public String dealPageTitle() {
		return driver.getTitle();
	}
	
}
