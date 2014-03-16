package com.example.tests;

import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
  
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
    initAddNewContact();
    
    ContactData contact = new ContactData();	
    contact.firstname = "John";
    contact.lastname = "Doe";
    contact.address = "3590 Marquette St, 95051 Santa Clara, Ca";
    contact.homephone = "+1-650-34-5678";
    contact.mobilephone = "+1-980-45-5678";
    contact.workphone = "+1-340-58-2345";
    contact.email = "john.doe.@gmail.com";
    contact.email2 = "john.doe2@gmail.com";
    contact.address2 = "3591 Market St, 98567 San Francisco, Ca";
    contact.phone2 = "+1-234-34-4567";
    fillNewContactPage(contact);
	
	ContactGroupData group = new ContactGroupData();
	group.selectedgroup = "group name 1";
	selectGroup(group);
	
	BirthDateData bdata = new BirthDateData();
	bdata.selectedbday = "20";
	bdata.selectedbmonth = "March";
	bdata.byear = "1981";
	bDateSelect(bdata);
	
    submitAddNewContact();
    returnMainPageFromAddNewContactPage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
    initAddNewContact();
    ContactData contact = new ContactData("", "", "", "", "", "", "", "", "", "");    
	fillNewContactPage(contact);
    submitAddNewContact();
    returnMainPageFromAddNewContactPage();
  } 

}
