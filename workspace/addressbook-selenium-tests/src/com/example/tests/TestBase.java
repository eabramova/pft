package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import com.example.utils.SortedListOf;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;

public class TestBase {
	
	protected static ApplicationManager app;
	
	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);		
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}
	
	@DataProvider	
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupsForDataProvider(generateRandomGroups(3)).iterator();				
	}
	
	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for(GroupData group : groups) {
			list.add(new Object[]{group});
		}		
		return list;	
	}	
	
	public static List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for(ContactData contact : contacts) {
			list.add(new Object[]{contact});
		}		
		return list;	
	}	

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		return wrapContactsForDataProvider(generateRandomContacts(3)).iterator();		
	}
		/*List<Object[]> list = new ArrayList<Object[]>();
		for(int i = 0; i < 3; i++) {
			ContactData contact = new ContactData()
			.withFirstName(generateRandomString())
			.withLastName(generateRandomString())
			.withAddress(generateRandomString())
			.withHomephone(generateRandomString())
			.withMobilephone(generateRandomString())
			.withWorkphone(generateRandomString())
			.withEmail(generateRandomString())
			.withEmail2(generateRandomString())
			//contact.selectedbday = "";
			//contact.selectedbmonth = "March";
			//contact.byear = "1971";
			//contact.selectedgroup = "";	
			.withAddress2(generateRandomString())
			.withPhone2(generateRandomString());			
		    
			list.add(new Object[]{contact});
		}		
		return list.iterator();		
	}	*/

	public String generateRandomString() {
		Random rnd = new Random();		
		if(rnd.nextInt(3) == 0) {
				return "";
		} else {
			return "test" + rnd.nextInt();
			}		
	}

	protected void checkEmailPhone(ContactData cd) {
		if(cd.email == null || cd.email.isEmpty()){
			cd.email = cd.email2;
		}		
		
		if(cd.homephone == null || cd.homephone.isEmpty()) {
			if(cd.mobilephone == null || cd.mobilephone.isEmpty())
				cd.homephone = cd.workphone;
			else
				cd.homephone = cd.mobilephone;
		}
	}
}