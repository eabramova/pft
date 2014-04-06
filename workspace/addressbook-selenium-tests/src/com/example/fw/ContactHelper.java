package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.BirthDateData;
import com.example.tests.ContactData;
import com.example.tests.ContactGroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);		
	}

	public void returnToMainPageFromAddEditContactPage() {		
		click(By.linkText("home page"));
	}
	
	/*****************************************************
	 * fill methods
	 ****************************************************/

	public void fillNewContactPage(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);	    
		type(By.name("home"), contact.homephone);	  
		type(By.name("mobile"), contact.mobilephone);	  	    
		type(By.name("work"), contact.workphone);		
		type(By.name("email"), contact.email);			
		type(By.name("email2"), contact.email2);		
		type(By.name("address2"), contact.address2);		
		type(By.name("phone2"), contact.phone2);	
	}
	
	/*****************************************************
	 * select methods
	 ****************************************************/

	public void selectGroup(ContactGroupData group) {
		selectByText(By.name("new_group"), group.selectedgroup);		
	}

	public void bDateSelect(BirthDateData bdate) {
		selectByText(By.name("bday"), bdate.selectedbday);
		selectByText(By.name("bmonth"), bdate.selectedbmonth);	        
	    type(By.name("byear"), bdate.byear);	    
	    
	}
	
	/*****************************************************
	 * init methods
	 ****************************************************/

	public void initAddNewContact() {		
		click(By.linkText("add new"));
	}
	
	public void initContactModificationByIndex(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index) + "]"));
	}	

	/*****************************************************
	 * submit methods
	 ****************************************************/
	
	public void submitAddNewContact() {		
	    click(By.name("submit"));
	}
	
	public void submitUpdateContact() {	
		click(By.xpath("//input[@value='Update']"));
	}
	
	public void submitDeleteContact() {		
	    click(By.xpath("//input[@value='Delete']"));
	}
	
	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();		
        int numOfRows = driver.findElements(By.xpath("//tbody/tr")).size();
		//System.out.println(numOfRows);		
		int colNum = 2;        
        for(int rowNum = 2 ; rowNum < numOfRows; rowNum++) {
        	WebElement lastNameCol = driver.findElement(By.xpath("//table/tbody/tr[" + rowNum + "]/td[" + colNum + "]"));
        	WebElement firstNameCol = driver.findElement(By.xpath("//table/tbody/tr[" + rowNum + "]/td[" + (colNum + 1) + "]"));
        	WebElement emailCol = driver.findElement(By.xpath("//table/tbody/tr[" + rowNum + "]/td[" + (colNum + 2) + "]"));
        	WebElement homePhoneCol = driver.findElement(By.xpath("//table/tbody/tr[" + rowNum + "]/td[" + (colNum + 3) + "]"));
        	ContactData contact = new ContactData();								
			contact.lastname = lastNameCol.getText();
			contact.firstname = firstNameCol.getText();	
			contact.email = emailCol.getText();	
			contact.homephone = homePhoneCol.getText();
			//System.out.println(contact.lastname + ", " + contact.firstname + ", " + contact.email + ", " + contact.homephone);			
			contacts.add(contact);        	
        }
        System.out.println(contacts);
        return contacts;         
    }	
	
}
