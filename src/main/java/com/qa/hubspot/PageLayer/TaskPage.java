package com.qa.hubspot.PageLayer;

import org.openqa.selenium.WebDriver;

public class TaskPage {

WebDriver driver;
	
	public TaskPage(WebDriver driver) {
		this.driver=driver;
		System.out.println("WebDriver code");
	}
	
	public void doTask() {
		System.out.println("Create a Task");
	}
	/**
	 * gives the title 
	 * @return
	 */
	public String dealPageTitle() {
		return driver.getTitle();
	}
	
}
