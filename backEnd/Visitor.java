//$Id$
package com.alex.zoho;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Visitor {
		
	 	private String name;
	    private String gender;
	    private String category;
	    private String email;
	    private String contact;
	    private  String password;
	    private int wallet;
	    private Ticket ticket;
	    
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getWallet() {
			return wallet;
		}
		public void setWallet(int wallet) {
			this.wallet = wallet;
		}
		public Ticket getTicket() {
			return ticket;
		}
		
		public void setTicket(Ticket ticket) {
			 this.ticket = ticket;
		}
	    
}
