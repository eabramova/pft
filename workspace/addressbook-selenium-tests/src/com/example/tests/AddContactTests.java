package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddContactTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
	  //open main page
    driver.get(baseUrl + "/addressbookv4.1.4/");
    // go to add new address book entry
    driver.findElement(By.linkText("add new")).click();
    // fill add new address book entry form
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("John");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("Doe");
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys("3590 Marquette St, 95051 Santa Clara, Ca");
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys("+1-980-45-5678");
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys("+1-650-34-5678");
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys("+1-340-58-2345");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("john.doe.@gmail.com");
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys("john.doe2@gmail.com");
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText("10");
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("April");
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys("1985");
    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("grou name 1");
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys("3591 Market St, 98567 San Francisco, Ca");
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys("+1-234-34-4567");
    //submit add new contact form creation
    driver.findElement(By.name("submit")).click();
    //return to main page
    driver.findElement(By.linkText("home page")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
