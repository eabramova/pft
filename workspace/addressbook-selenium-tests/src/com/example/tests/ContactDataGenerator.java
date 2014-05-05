package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {	
	public static void main(String[] args) throws IOException {
		if(args.length < 3) {
			System.out.println("Please specify parameters: <quantity of test data> <file> <format>");
			return;
		}		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if(file.exists()) {
			System.out.println("File exists, please remove it manually: " + file);
			return;
		}		
		List<ContactData> contacts = generateRandomContacts(amount);
		if("csv".equalsIgnoreCase(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if("xml".equalsIgnoreCase(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format: " + format);
			return;
		}			
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);		
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for(ContactData contact : contacts) {
			writer.write(contact.getFirstname() + "," + contact.getLastname() + "," + contact.getAddress() 
					+ "," + contact.getHomephone() + "," + contact.getMobilephone() + "," + contact.getWorkphone() 
					+ "," + contact.getEmail() + "," + contact.getEmail2() + "," + contact.getAddress2() + "," + contact.getPhone2() + ",!" + "\n");
		}
		writer.close();		
	} 
		
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while(line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
			.withFirstName(part[0])
			.withLastName(part[1])
			.withAddress(part[2])
			.withHomephone(part[3])
			.withMobilephone(part[4])
			.withWorkphone(part[5])
			.withEmail(part[6])
			.withEmail2(part[7])
			//contact.selectedbday = "";
			//contact.selectedbmonth = "March";
			//contact.byear = "1971";
			//contact.selectedgroup = "";	
			.withAddress2(part[8])
			.withPhone2(part[9]);	
			
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for(int i = 0; i < amount; i++) {
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
			list.add(contact);
		}		
		return list;	
	}	
	
	public static String generateRandomString() {
		Random rnd = new Random();		
		if(rnd.nextInt(3) == 0) {
				return "";
		} else {
			return "test" + rnd.nextInt();
			}		
	}
}
