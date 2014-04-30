package com.example.tests;

import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import com.example.utils.SortedListOf;

public class AddContactTests extends TestBase {	
	
  @Test(dataProvider = "randomValidContactGenerator")
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
