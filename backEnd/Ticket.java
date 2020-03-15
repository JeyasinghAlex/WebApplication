//$Id$
package com.alex.zoho;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ticket {
	public static int number = 100;
	protected int ticketNumber;
    protected String type;
    //protected Date date;
     
    public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber){
		this.ticketNumber = ticketNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
//	public Date getDate() {
//		return date;
//	}
//	public void setDate(Date date) {
//		this.date = date;
//	}
}
