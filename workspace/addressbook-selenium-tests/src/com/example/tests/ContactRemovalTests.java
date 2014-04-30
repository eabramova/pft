package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	
	@Test
	public void removeContactByIndex() {
		
		//save old state
		SortedListOf<ContactData> oldContactsList = app.getContactHelper().getContacts(); 
					
		Random rnd = new Random();
		int index = rnd.nextInt(oldContactsList.size() - 1); //works if oldContactsList.size() > 1		
		
		//actions
		app.getContactHelper().deleteContact(index);	
	    
	    //save new state
	    SortedListOf<ContactData> newContactsList = app.getContactHelper().getContacts(); 
	    
	    //compare states
	    assertThat(newContactsList, equalTo(oldContactsList.without(index)));	   
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