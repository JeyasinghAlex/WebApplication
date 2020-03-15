//$Id$
package com.alex.zoho;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.json.JSONObject;

public class VisitorDao {
	private static int number = 100;
	public Response insertVisitor(Visitor visitor)
	{
		 PreparedStatement pstmt = null;
	     String query = "insert into visitors (name, gender, category, password, email, contact)  values (?, ?, ?, ?, ?, ?)";
	     String qry = "insert into tickets (number) values (?)";
        try{
            pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
            pstmt.setString(1, visitor.getName());
            pstmt.setString(2, visitor.getGender());
            pstmt.setString(3, visitor.getCategory());
            pstmt.setString(4,visitor.getPassword());  
            pstmt.setString(5, visitor.getEmail());
            pstmt.setString(6, visitor.getContact());
            pstmt.execute();
            pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(qry);
            pstmt.setInt(1, visitor.getTicket().getTicketNumber());
            pstmt.execute();
            return Response.status(Response.Status.OK).entity("Registation is sucessfully completed").build();        
        }catch(Exception ex){
        	System.out.println(ex);
        }
        return null;
	}
	
	public List<Visitor> getVisitors(){
		
		List<Visitor> visitors = new ArrayList<>();
		String visitorQuery = "select * from visitors";
		String ticketQuery = "select * from tickets";
		
		try{
            ResultSet rs = DataBaseConnection.getDbInstance().getConnection().prepareStatement(visitorQuery).executeQuery();
            ResultSet ts = DataBaseConnection.getDbInstance().getConnection().prepareStatement(ticketQuery).executeQuery();
			while(rs.next() && ts.next()){
				Visitor visitor = new Visitor();
				Ticket ticket = new Ticket();
				
				visitor.setName(rs.getString(2));
				visitor.setGender(rs.getString(3));
				visitor.setCategory(rs.getString(4));
				visitor.setEmail(rs.getString(7));
				visitor.setContact(rs.getString(8));
				ticket.setTicketNumber(ts.getInt(2));
				
				visitor.setTicket(ticket);
				visitors.add(visitor);
			}
			return visitors;
		}catch(Exception ex){
			System.out.println(ex);
		}
		return visitors;
	}
	
	public Visitor getVisitor(int ticketNumber){
		Visitor visitor = new Visitor();
		Ticket ticket = new Ticket();
		 String query = "select visitors.name, visitors.gender, visitors.category from visitors inner join tickets  "
		 		+ "on visitors.id = tickets.id where tickets.number = ?";
		try{
			PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
			pstmt.setInt(1,ticketNumber);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				visitor.setName(rs.getString(1));
				visitor.setGender(rs.getString(2));
				visitor.setCategory(rs.getString(3));
				
			}
			
		}catch(Exception ex){
			System.out.println(ex);
		}
		return visitor;
	}
	
	public JSONObject getVisitor(String userName, String password){
		JSONObject json = new JSONObject();
		//String query = "select * from visitors where name = ? and password = ?";
		//String qry = "select number from tickets where id = ?";
		String query = "select * from visitors";
		Visitor visitor = new Visitor();
		//Ticket ticket = new Ticket();
		try{
			ResultSet rs =  DataBaseConnection.getDbInstance().getConnection().prepareStatement(query).executeQuery();
			while(rs.next()){
				//PreparedStatement stmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(qry);
				String name = rs.getString(2);
				if(name.equals(userName)){
					String pass = rs.getString(6);
					if(pass.equals(password)){
						System.out.println("user account find");
						return json.put("result", true);
					}
				}
			}
			
		}catch(Exception ex){
			System.out.println(ex);
		}
		return json.put("result", false);
	}
	
	

}
