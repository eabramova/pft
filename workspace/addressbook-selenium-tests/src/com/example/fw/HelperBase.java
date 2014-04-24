package com.example.fw;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//import com.example.tests.ContactData;

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
		findElement(locator).clear();
		if(text != null && !text.isEmpty()) {	
			findElement(locator).sendKeys(text);
		}		
	}

	protected WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	protected List<WebElement> findElements(By locator) {	
		return driver.findElements(locator);
	}	
		
	protected void click(By locator) {
		findElement(locator).click();
	}
	
	protected void selectByText(By locator, String text) {
		new Select(findElement(locator)).selectByVisibleText(text);
	}
	
	protected void selectByIndex(By locator, int index) {
		new Select(findElement(locator)).selectByIndex(index);		
	}


}
