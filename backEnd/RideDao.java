//$Id$
package com.alex.zoho;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.ws.rs.core.Response;

public class RideDao {
	
	public List<Ride> getRides(){
		ArrayList<Ride> rides = new ArrayList<>();
		String query = "select * from rides ";
		//String ride_details = "select * from ride_details";
		try{
			 ResultSet rs = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query).executeQuery();
			// ResultSet ts = DataBaseConnection.getDbInstance().getConnection().prepareStatement(ride_details).executeQuery();
	         while(rs.next()){
	        	Ride ride = new Ride();
	        	ride.setRideName(rs.getString(2));
	        	/*ride.setRideId(ts.getInt(2));
	        	ride.setStartTime(ts.getInt(3));
	        	ride.setEndTime(ts.getInt(4));
	        	ride.setAllowChildren(ZohoUtil.getUtilInstance().findBoolean(ts.getString(5)));
	        	ride.setAllowAdult(ZohoUtil.getUtilInstance().findBoolean(ts.getString(6)));
	        	ride.setAllowSenior(ZohoUtil.getUtilInstance().findBoolean(ts.getString(7)));
	        	ride.setAmount(ts.getInt(8));*/
	        	rides.add(ride);
	         }
		}catch(Exception ex){
			System.out.println(ex);
		}
		return rides;
	}
	
	
	public Response insertRideConfiguration(Ride ride){
		String query = "insert into ride_details(ride_id, start_time, end_time, is_allow_child, is_allow_adult, is_allow_senior, per_ride_amount)"
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		try{
			PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
			pstmt.setInt(1, ride.getRideId());
			pstmt.setInt(2, ride.getStartTime());
			pstmt.setInt(3,  ride.getEndTime());
			pstmt.setString(4, ZohoUtil.getUtilInstance().isAllowRide(ride.isAllowChildren));
			pstmt.setString(5, ZohoUtil.getUtilInstance().isAllowRide(ride.isAllowAdult));
			pstmt.setString(6, ZohoUtil.getUtilInstance().isAllowRide(ride.isAllowSenior));
			pstmt.setInt(7, ride.getAmount());
			pstmt.execute();
			System.out.println("I am ride Configuration");
			return Response.status(Response.Status.OK).entity("Ride Configuration is sucessfully completed").build(); 
		}catch(Exception ex){
			System.out.println(ex);
		}
		return null;
	}
	
	public int findRideId(String rideName){
		String query = "select id from rides where name = ?";
		try{
			PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
			pstmt.setString(1,rideName);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		}catch(Exception ex){
			System.out.println(ex);
		}
		return 0;
	}
	
	public Ride getRideDetails(int id){
		String query = "select * from ride_details where id = ?";
		Ride ride = new Ride();
		try{
			PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				ride.setStartTime(rs.getInt(3));
				ride.setEndTime(rs.getInt(4));
				ride.setAllowChildren(ZohoUtil.getUtilInstance().findBoolean(rs.getString(5)));
				ride.setAllowAdult(ZohoUtil.getUtilInstance().findBoolean(rs.getString(6)));
				ride.setAllowSenior(ZohoUtil.getUtilInstance().findBoolean(rs.getString(7)));
				ride.setAmount(rs.getInt(8));
				return ride;
			}
		}catch(Exception ex){
			System.out.println(ex);
		}
		return ride;
	}
}
