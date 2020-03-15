//$Id$
package com.alex.zoho;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ride")
public class RideController {

	RideDao dao = new RideDao();
	
	@GET
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})   
	public ArrayList<Ride> getRides(){
		ArrayList<Ride> rides =  dao.getRides();
		return rides;
	}
	
	@POST
	@Path("ride-configuration")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public void rideConfiguration(@FormParam("selected_ride") String rideName, @FormParam("start_time") String start_time,@FormParam("end_time") String end_time, @FormParam("is_allow_child") String is_allow_child,
			@FormParam("is_allow_adult") String is_allow_adult, @FormParam("is_allow_senior") String is_allow_senior,  @FormParam("ride_amount") String ride_amount){
		System.out.println("I am ride configuration controller");
		Ride ride = new Ride();
		int ride_id = dao.findRideId(rideName);
		System.out.println(ride_id);
		ride.setRideId(ride_id);
		ride.setStartTime(Integer.parseInt(start_time));
		ride.setEndTime(Integer.parseInt(end_time));
		ride.setAllowChildren(ZohoUtil.getUtilInstance().findBoolean(is_allow_child));
		ride.setAllowAdult(ZohoUtil.getUtilInstance().findBoolean(is_allow_adult));
		ride.setAllowSenior(ZohoUtil.getUtilInstance().findBoolean(is_allow_senior));
		ride.setAmount(Integer.parseInt(ride_amount));	
		dao.insertRideConfiguration(ride);
	}
	
	@GET
	@Path("get-ride-details")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})   
	public ArrayList<Ride> getAllRides(){
		System.out.println("Hello World");
		ArrayList<Ride> rides =  dao.getRides();
		return rides;
	}
}
