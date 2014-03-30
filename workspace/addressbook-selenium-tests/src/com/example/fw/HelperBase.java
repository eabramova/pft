package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class HelperBase {
	
	protected ApplicationManager manager;
	protected WebDriver driver;	
	
	public HelperBase(ApplicationManager manager) {		
		this.manager = manager;
		this.driver = manager.driver;
	}
	
	/*****************************************************
	 * 
	 * Common working methods
	 * 
	 ****************************************************/
	
	public boolean isElementPresent(By by) {
	    try {
	      findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
	public boolean isAlertPresent() {
	    try {
	    	driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	protected void type(By locator, String text) {
		if(text != null) {		
		findElement(locator).clear();	    
		findElement(locator).sendKeys(text);
		}
	}

	protected WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	protected void click(By locator) {
		findElement(locator).click();
	}
	
	protected void selectByText(By locator, String text) {
		new Select(findElement(locator)).selectByVisibleText(text);
	}
}
