package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	
	@Test
	public void removeContactByIndex() {
		app.navigateTo().mainPage();
		//save old state
		List<ContactData> oldContactsList = app.getContactHelper().getContacts(); 
					
		Random rnd = new Random();
		int index = rnd.nextInt(oldContactsList.size() - 1); //works if oldContactsList.size() > 1
				
		//actions
		app.getContactHelper().initContactModificationByIndex(index + 1);		
		app.getContactHelper().submitDeleteContact();			   
	    app.getContactHelper().returnToMainPageFromAddEditContactPage();
	    app.getContactHelper().rebuildCash();
	    
	    //save new state
	    List<ContactData> newContactsList = app.getContactHelper().getContacts(); 
	    
	    //compare states	    
	    oldContactsList.remove(index);
	    //checkHomePhoneAndEmail(contact);
	    Collections.sort(oldContactsList);
	    Collections.sort(newContactsList);
	    assertEquals(newContactsList, oldContactsList);
	}
	
	/*
	@Test
	public void removeAllContactsPlusOne() {
		//app.getNavigationHelper().openMainPage();
		app.navigateTo().mainPage();
		//save old state
		List<ContactData> ContactsList = app.getContactHelper().getContacts(); 
		
		for(int i = 0; i <ContactsList.size(); i++) {
			
		app.getContactHelper().initContactModificationByIndex(i + 1);
		app.getContactHelper().submitDeleteContact();			   
	    app.getContactHelper().returnToMainPageFromAddEditContactPage();	     
		}
	} */
	
}
