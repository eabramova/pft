package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
		
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifyContactByIndex(ContactData contact) {
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldContactsList = app.getContactHelper().getContacts(); 
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldContactsList.size()); //works if oldContactsList.size() > 1
		
		//actions
		app.getContactHelper().initContactModificationByIndex(index + 1);		
		app.getContactHelper().fillNewContactPage(contact);
		app.getContactHelper().submitUpdateContact();			   
	    app.getContactHelper().returnToMainPageFromAddEditContactPage();
	   
	    //save new state
	    List<ContactData> newContactsList = app.getContactHelper().getContacts(); 
	    
	    //compare states	    
	    oldContactsList.remove(index);
	    checkHomePhoneAndEmail(contact);
	    oldContactsList.add(contact);
	    Collections.sort(oldContactsList);
	    Collections.sort(newContactsList);
	    assertEquals(newContactsList, oldContactsList);
	}
	
}
