package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String homephone;
	public String mobilephone;
	public String workphone;
	public String email;
	public String email2;
	public String address2;
	public String phone2;
	public String selectedgroup;
	public String selectedbday;
	public String selectedbmonth;
	//public String byear;
	
	public ContactData() {
		
	}

	public ContactData(String firstname, String lastname, String address,
			String homephone, String mobilephone, String workphone,
			String email, String email2, String address2, String phone2
			//String byear
			) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.homephone = homephone;
		this.mobilephone = mobilephone;
		this.workphone = workphone;
		this.email = email;
		this.email2 = email2;
		this.address2 = address2;
		this.phone2 = phone2;
		//this.byear = byear;
	}
}