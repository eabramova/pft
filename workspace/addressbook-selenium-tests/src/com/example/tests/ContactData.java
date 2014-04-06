package com.example.tests;

public class ContactData implements Comparable<ContactData> {
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
	
	@Override
	public String toString() {
		return "ContactData [lastname=" + lastname + ", firstname=" + firstname + ", email=" + email + ", homephone=" + homephone + "]";
		
	}

	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (lastname == null && firstname == null) {
			if (other.lastname != null && firstname != null)
				return false;
		} else if (!lastname.equals(other.lastname) && !firstname.equalsIgnoreCase(other.firstname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return (this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase()) & this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase()));		
	}
	
}