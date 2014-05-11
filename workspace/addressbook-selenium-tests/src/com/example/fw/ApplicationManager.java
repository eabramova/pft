package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class ApplicationManager {
	
	private WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	//private HelperBase contactHelper;
	public Properties properties;
	private HibernateHelper hibernateHelper;
	
	public ApplicationManager(Properties properties) {
	    this.properties = properties;	        
	}
	    	
	public void stop() {
		driver.quit();	    
	}
	
	public NavigationHelper navigateTo() {
		if(navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}
	
	public GroupHelper getGroupHelper() {
		if(groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}
	
	public ContactHelper getContactHelper() {
		if(contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}
	
	public HibernateHelper getHibernateHelper() {
		if(hibernateHelper == null) {
			hibernateHelper = new HibernateHelper(this);
		}
		return hibernateHelper;
		
	}

	public WebDriver getDriver() {
		if(driver == null) {	
			String browser = properties.getProperty("browser");	
			if("firefox".equalsIgnoreCase(browser)){
		    	driver = new FirefoxDriver();
		    } else if("chrome".equalsIgnoreCase(browser)) {
		    	driver = new ChromeDriver();
		    } else if("ie".equalsIgnoreCase(browser)) {
		    	driver = new InternetExplorerDriver();
		    } else {
		    	throw new Error("Unsupported new browser: " + browser);
		    }
		    baseUrl = properties.getProperty("baseUrl");
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.get(baseUrl);
		}
		return driver;
	}

}
