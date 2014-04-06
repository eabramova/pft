package com.example.tests;

import java.util.List;
import java.util.Collections;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
  
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	
	//save old state
	List<ContactData> oldContactsList = app.getContactHelper().getContacts(); 
	
	//actions
    app.getContactHelper().initAddNewContact();    
    ContactData contact = new ContactData();	
    contact.firstname = "Anna";
    contact.lastname = "Annova";
    contact.address = "3590 Marquette St, 95051 Santa Clara, Ca";
    contact.homephone = "+1-650-34-5679";
    contact.mobilephone = "+1-980-45-5678";
    contact.workphone = "+1-340-58-2345";
    contact.email = "john.doe.@gmail.com";
    contact.email2 = "john.doe2@gmail.com";
    contact.address2 = "3591 Market St, 98567 San Francisco, Ca";
    contact.phone2 = "+1-234-34-4567";
    app.getContactHelper().fillNewContactPage(contact);
	
	ContactGroupData group = new ContactGroupData();
	group.selectedgroup = "group name 1";
	app.getContactHelper().selectGroup(group);
	
	BirthDateData bdata = new BirthDateData();
	bdata.selectedbday = "20";
	bdata.selectedbmonth = "March";
	bdata.byear = "1981";
	app.getContactHelper().bDateSelect(bdata);
	
    app.getContactHelper().submitAddNewContact();
    app.getContactHelper().returnToMainPageFromAddEditContactPage();
    
    //save new state
    List<ContactData> newContactsList = app.getContactHelper().getContacts(); 
    
    //compare states
    oldContactsList.add(contact);
    Collections.sort(oldContactsList);
    Collections.sort(newContactsList);
    assertEquals(newContactsList, oldContactsList);
    
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	
	//save old state
	List<ContactData> oldContactsList = app.getContactHelper().getContacts(); 
		
	//actions
    app.getContactHelper().initAddNewContact();
    ContactData contact = new ContactData("", "", "", "", "", "", "", "", "", "");    
	app.getContactHelper().fillNewContactPage(contact);
    app.getContactHelper().submitAddNewContact();
    app.getContactHelper().returnToMainPageFromAddEditContactPage();
    
    //save new state
    List<ContactData> newContactsList = app.getContactHelper().getContacts(); 
    
    //compare states
    oldContactsList.add(contact);
    Collections.sort(oldContactsList);
    Collections.sort(newContactsList);
    assertEquals(newContactsList, oldContactsList);
  } 

}
