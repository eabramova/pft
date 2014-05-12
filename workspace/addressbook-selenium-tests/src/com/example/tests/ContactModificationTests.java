package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	@DataProvider	
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();				
	}  
	
	@Test(dataProvider = "contactsFromFile")	
	public void modifyContactByIndex(ContactDataModification contact) throws Exception {
				
		//save old state
		//SortedListOf<ContactDataModification> oldContactsList = app.getContactHelper().getContacts(); 
	  	SortedListOf<ContactData> oldContactsList 
		= new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldContactsList.size() - 1); //works if oldContactsList.size() > 1
	    		
		//actions			
		app.getContactHelper().modifyContact(index, contact);
	    	   
	    //save new state
	    SortedListOf<ContactData> newContactsList = app.getContactHelper().getContacts(); 
	    
	    //compare states
	        
	    assertThat(newContactsList, equalTo(oldContactsList.without(index).withAdded(contact)));	    
	}
	
}