package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
		
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifyContactByIndex(ContactData contact) {
				
		//save old state
		SortedListOf<ContactData> oldContactsList = app.getContactHelper().getContacts(); 
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldContactsList.size() - 1); //works if oldContactsList.size() > 1
	    		
		//actions			
		app.getContactHelper().modifyContact(index, contact);
	    	   
	    //save new state
	    SortedListOf<ContactData> newContactsList = app.getContactHelper().getContacts(); 
	    
	    //compare states
	    checkHomePhoneAndEmail(contact);
	    
	    assertThat(newContactsList, equalTo(oldContactsList.without(index).withAdded(contact)));	    
	}
	
}