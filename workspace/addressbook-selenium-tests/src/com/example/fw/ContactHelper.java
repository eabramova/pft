package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);		
	}
	
	private SortedListOf<ContactData> cachedContacts;	
	
	public SortedListOf<ContactData> getContacts() {
		if(cachedContacts == null) {
			rebuildCash();
		}
		return cachedContacts;
	}	
	
	public void rebuildCash() {
		cachedContacts = new SortedListOf<ContactData>();	
		manager.navigateTo().mainPage();
        int numOfRows = findElements(By.xpath("//tbody/tr")).size();
		//System.out.println(numOfRows);		
		int colNum = 2;        
        for(int rowNum = 2 ; rowNum < numOfRows; rowNum++) {
        	WebElement lastNameCol = findElement(By.xpath("//table/tbody/tr[" + rowNum + "]/td[" + colNum + "]"));
        	WebElement firstNameCol = findElement(By.xpath("//table/tbody/tr[" + rowNum + "]/td[" + (colNum + 1) + "]"));
        	WebElement emailCol = findElement(By.xpath("//table/tbody/tr[" + rowNum + "]/td[" + (colNum + 2) + "]"));
        	WebElement homePhoneCol = findElement(By.xpath("//table/tbody/tr[" + rowNum + "]/td[" + (colNum + 3) + "]"));
        	
        	ContactData contact = new ContactData()
        	.withLastName(lastNameCol.getText())
        	.withFirstName(firstNameCol.getText())
        	.withEmail(emailCol.getText())
        	.withHomephone(homePhoneCol.getText());
        	
			/*contact.lastname = lastNameCol.getText();
			contact.firstname = firstNameCol.getText();	
			contact.email = emailCol.getText();	
			contact.homephone = homePhoneCol.getText();*/
			
			if(contact.getLastname() == null) contact.lastname = "";
			if(contact.getFirstname() == null) contact.firstname = "";
			if(contact.getEmail() == null) contact.email = "";
			if(contact.getHomephone() == null) contact.homephone = "";
			
			//System.out.println(contact.lastname + ", " + contact.firstname + ", " + contact.email + ", " + contact.homephone);			
			cachedContacts.add(contact);        	
        }                 
    }	
	
	public ContactHelper addContact(ContactData contact) {
		initAddNewContact();
    	fillNewContactPage(contact);
    	submitAddNewContact();
    	returnToMainPageFromAddEditContactPage();
    	rebuildCash();
    	return this;		
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactModificationByIndex(index);
    	fillNewContactPage(contact);
    	submitUpdateContact();
    	returnToMainPageFromAddEditContactPage(); 
    	rebuildCash();
    	return this;		
	}
	
	public ContactHelper deleteContact(int index) {		
		initContactModificationByIndex(index);
		submitDeleteContact();
		returnToMainPageFromAddEditContactPage();
		rebuildCash();
		return this;
	}	
	
	//----------------------------------------------
	
	public ContactHelper submitAddNewContact() {		
	    click(By.name("submit"));
	    cachedContacts = null;
	    return this;	 
	}
	
	public ContactHelper submitUpdateContact() {	
		click(By.xpath("//input[@value='Update']"));
		return this;
		//cachedContacts = null;			
	}
	
	public ContactHelper submitDeleteContact() {		
	    click(By.xpath("//input[@value='Delete']"));
	    cachedContacts = null;
	    return this;
	}	
	
	//----------------------------------------------

	public ContactHelper initAddNewContact() {	
		manager.navigateTo().mainPage();
		click(By.linkText("add new"));
		return this;
	}
	
	public ContactHelper initContactModificationByIndex(int index) {
		manager.navigateTo().mainPage();
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
		return this;
	}	
	

	public ContactHelper returnToMainPageFromAddEditContactPage() {		
		click(By.linkText("home page"));
		return this;
	}	

	//----------------------------------------------

	public ContactHelper fillNewContactPage(ContactData contact) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());	    
		type(By.name("home"), contact.getHomephone());	  
		type(By.name("mobile"), contact.getMobilephone());	  	    
		type(By.name("work"), contact.getWorkphone());		
		type(By.name("email"), contact.getEmail());			
		type(By.name("email2"), contact.getEmail2());
		//selectByText(By.name("bday"), contact.selectedbday);
		//selectByIndex(By.name("bday"), getIndex("bday"));
		//selectByIndex(By.name("bmonth"), getIndex("bmonth"));	        
	    //type(By.name("byear"), contact.byear);
	    //selectByIndex(By.name("new_group"), getIndex("new_group"));
		type(By.name("address2"), contact.getAddress2());		
		type(By.name("phone2"), contact.getPhone2());
		return this;
	}
	
	/*****************************************************
	 * select methods
	 ****************************************************/
/*
	public void selectGroup(ContactGroupData group) {
		selectByText(By.name("new_group"), group.selectedgroup);		
	}

	public void bDateSelect(BirthDateData bdate) {
		selectByText(By.name("bday"), bdate.selectedbday);
		selectByText(By.name("bmonth"), bdate.selectedbmonth);	        
	    type(By.name("byear"), bdate.byear);	    
	    
	}	
	
	private int getIndex(String selectname) {
		Select se = new Select(driver.findElement(By.name(selectname)));
		List<WebElement> l = se.getOptions();		
		int selectsize = l.size();
		System.out.println(selectsize);
		Random rnd = new Random();
		return rnd.nextInt(selectsize) + 1;		
	}*/		
	
}
