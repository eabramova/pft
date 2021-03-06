package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	public String firstname;
	public String lastname;
	private String address;
	public String homephone;
	public String mobilephone;
	public String workphone;
	public String email;
	public String email2;
	//public String selectedbday;
	//public String selectedbmonth;
	//public String byear;
	//public String selectedgroup;
	private String address2;
	private String phone2;
	private String id;

	public ContactData() {

	}

	public ContactData(String firstname, String lastname, String address,
			String homephone, String mobilephone, String workphone,
			String email, String email2, 
			//String selectedbday, String selectedbmonth, String byear, String selectedgroup, 
			String address2, String phone2) 
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.homephone = homephone;
		this.mobilephone = mobilephone;
		this.workphone = workphone;
		this.email = email;
		this.email2 = email2;
		//this.selectedbday = selectedbday;
		//this.selectedbmonth = selectedbmonth;
		//this.byear = byear;
		//this.selectedgroup = selectedgroup;
		this.address2 = address2;
		this.phone2 = phone2;			
	}

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname
				+ ", homephone=" + homephone + ", email=" + email + "]";
	}	

	@Override
	public int hashCode() {
		int result = 1;				
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;		
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;		
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (homephone == null) {
			if (other.homephone != null)
				return false;
		} else if (!homephone.equals(other.homephone))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;		
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		String contactData1 = firstname.toLowerCase() + firstname.length() + lastname.toLowerCase() + lastname.length() + email.toLowerCase() + email.length() + homephone.toLowerCase() + homephone.length();
		String contactData2 = other.firstname.toLowerCase() + other.firstname.length() + other.lastname.toLowerCase() + other.lastname.length() + other.email.toLowerCase() + other.email.length() + other.homephone.toLowerCase() + other.homephone.length();
		return contactData1.compareTo(contactData2);			
	}

	//setters
	public ContactData withId(String id) {		
		this.id = id;
		return this;
	}

	public ContactData withFirstName(String firstname) {		
		this.firstname = firstname;
		return this;
	}

	public ContactData withLastName(String lastname) {		
		this.lastname = lastname;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHomephone(String homephone) {		
		this.homephone = homephone;
		return this;
	}

	public ContactData withMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
		return this;
	}

	public ContactData withWorkphone(String workphone) {
		this.workphone = workphone;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;	
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;		
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;		
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;		
		return this;
	}	

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public void setId(String id) {
		this.id = id;
	}

	//getters
	public String getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getHomephone() {
		return homephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public String getWorkphone() {
		return workphone;
	}

	public String getEmail() {		
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}	
}