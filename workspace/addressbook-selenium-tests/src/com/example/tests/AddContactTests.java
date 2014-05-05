package com.example.tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
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
	SortedListOf<ContactData> oldContactsList = app.getContactHelper().getContacts(); 
	
	//actions
	app.getContactHelper().addContact(contact);	
     
    //save new state
    SortedListOf<ContactData> newContactsList = app.getContactHelper().getContacts(); 
    
    //compare states
    checkHomePhoneAndEmail(contact);
    
    assertThat(newContactsList, equalTo(oldContactsList.withAdded(contact)));   
  }
}

/*
ContactGroupData group = new ContactGroupData();
group.selectedgroup = "group name 1";
app.getContactHelper().selectGroup(group);

BirthDateData bdata = new BirthDateData();
bdata.selectedbday = "20";
bdata.selectedbmonth = "March";
bdata.byear = "1981";
app.getContactHelper().bDateSelect(bdata);
*/	

/*oldContactsList.add(contact);    
Collections.sort(oldContactsList);
Collections.sort(newContactsList);
assertEquals(newContactsList, oldContactsList);   */ 
