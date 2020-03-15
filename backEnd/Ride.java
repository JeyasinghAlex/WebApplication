//$Id$
package com.alex.zoho;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ride {
	
	protected String rideName;
	protected int rideId;
	protected int amount;
    protected int startTime;
    protected int endTime;
    protected boolean isAllowAdult;
    protected boolean isAllowChildren;
    protected boolean isAllowSenior;
    protected boolean isConfigure;
    //protected Operator operator;
  
	 public String getRideName() {
		return rideName;
	}
	public void setRideName(String rideName) {
		this.rideName = rideName;
	}
	 public int getRideId() {
			return rideId;
	}
	public void setRideId(int rideId) {
			this.rideId = rideId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public boolean isAllowAdult() {
		return isAllowAdult;
	}
	public void setAllowAdult(boolean isAllowAdult) {
		this.isAllowAdult = isAllowAdult;
	}
	public boolean isAllowChildren() {
		return isAllowChildren;
	}
	public void setAllowChildren(boolean isAllowChildren) {
		this.isAllowChildren = isAllowChildren;
	}
	public boolean isAllowSenior() {
		return isAllowSenior;
	}
	public void setAllowSenior(boolean isAllowSenior) {
		this.isAllowSenior = isAllowSenior;
	}
	public boolean isConfigure() {
		return isConfigure;
	}
	public void setConfigure(boolean isConfigure) {
		this.isConfigure = isConfigure;
	}	
}
