package com.example.tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
//import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import com.example.utils.SortedListOf;

public class AddContactTests extends TestBase {
	
	@DataProvider	
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();				
		//return wrapContactsForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
	}  
	
  @Test(dataProvider = "contactsFromFile")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
		
	//save old state
	SortedListOf<ContactData> oldContactsList 
		= new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());	
	
	for(ContactData cd: oldContactsList) {
		checkEmailPhone(cd);			
	}
		  
	//actions
	app.getContactHelper().addContact(contact);	
	checkEmailPhone(contact);
     
    //save new state     
	SortedListOf<ContactData> newContactsList = app.getContactHelper().getContacts(); 
    //compare states    
    
    assertThat(newContactsList, equalTo(oldContactsList.withAdded(contact)));   
  }
}