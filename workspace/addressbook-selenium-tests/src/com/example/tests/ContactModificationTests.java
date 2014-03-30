package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
		
	@Test
	public void modifyContactByIndex() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModificationByIndex(1);
		ContactData contact = new ContactData();
		contact.firstname = "Elena";
		contact.lastname = "Ivanova";
		app.getContactHelper().fillNewContactPage(contact);
		app.getContactHelper().submitUpdateContact();			   
	    app.getContactHelper().returnToMainPageFromAddEditContactPage();		
	}
	
}
