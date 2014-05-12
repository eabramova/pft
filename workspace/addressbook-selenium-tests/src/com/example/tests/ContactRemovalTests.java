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
		SortedListOf<ContactData> oldContactsList 
		= new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());	
	
		for(ContactData cd: oldContactsList) {
			checkEmailPhone(cd);			
		}
					
		Random rnd = new Random();
		int index = rnd.nextInt(oldContactsList.size() - 1); //works if oldContactsList.size() > 1		
		
		//actions
		app.getContactHelper().deleteContact(index);	
	    
	    //save new state
	    SortedListOf<ContactData> newContactsList = app.getContactHelper().getContacts(); 
	    
	    //compare states
	    assertThat(newContactsList, equalTo(oldContactsList.without(index)));	   
	}	
}