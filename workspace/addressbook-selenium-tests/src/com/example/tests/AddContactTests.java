package com.example.tests;

import java.util.List;
import java.util.Collections;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {	
	
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	app.navigateTo().mainPage();
	
	//save old state
	List<ContactData> oldContactsList = app.getContactHelper().getContacts(); 
	
	//actions
    app.getContactHelper().initAddNewContact();    
    app.getContactHelper().fillNewContactPage(contact);
	
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
	
    app.getContactHelper().submitAddNewContact();
    app.getContactHelper().returnToMainPageFromAddEditContactPage();
    app.getContactHelper().rebuildCash();
    
    //save new state
    List<ContactData> newContactsList = app.getContactHelper().getContacts(); 
    
    //compare states
    checkHomePhoneAndEmail(contact);
    
    oldContactsList.add(contact);    
    Collections.sort(oldContactsList);
    Collections.sort(newContactsList);
    assertEquals(newContactsList, oldContactsList);    
  }

}
