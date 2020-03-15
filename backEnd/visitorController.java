//$Id$
package com.alex.zoho;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.sun.media.sound.SoftSynthesizer;

import org.json.JSONArray;

@Path("visitor")
public class visitorController {
	
	VisitorDao dao = new VisitorDao();

	
	@GET
	@Path("get-all-visitors")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})   //Both are acceptable format
	public List<Visitor> getVisitors()
	{	
		System.out.println("I am get all visitors");
		List<Visitor> visitors = dao.getVisitors();
		return visitors;
	}
	
	@POST
	@Path("search-user-account")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchUserAccount(@FormParam("userName") String userName, @FormParam("password")String password){
		//JSONObject json = new JSONObject();
		String encriptedPassword = ZohoUtil.getUtilInstance().encryptedPassword(password);
		 JSONObject jsonResult = dao.getVisitor(userName, encriptedPassword);
		 System.out.println("I am search-user-account controller");
		 System.out.println(jsonResult.get("result"));
		// json.put("result", result);
		 return Response.ok(jsonResult.toString()).build();
		// return jsonResult;
	}
	
	@POST
	//@Consumes( MediaType.APPLICATION_FORM_URLENCODED )
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Response instertVisitors(@FormParam("name") String name, @FormParam("gender") String gender,
			@FormParam("category") String category, @FormParam("email") String email, @FormParam("contact") String contact, @FormParam("password") String password)
	{
		Visitor visitor = new Visitor();
		Ticket ticket = new Ticket();
		visitor.setName(name);
		visitor.setGender(gender);
		visitor.setCategory(category);
		visitor.setEmail(email);
		visitor.setContact(contact);
		visitor.setPassword(ZohoUtil.getUtilInstance().encryptedPassword(password));
		ticket.setTicketNumber(++Ticket.number);
		visitor.setTicket(ticket);
		return (dao.insertVisitor(visitor));
	}
	
	@GET
	@Path("search-visitor/{ticketNumber}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Visitor getVisitor(@PathParam("ticketNumber") int ticketNumber){
		Visitor visitor = dao.getVisitor(ticketNumber);
		if(visitor.getName() != null){
			return visitor;
		}
		return null;
	}
	
	
//	
//	public int checkWallet(){
//		return 0;
//	}
//	public JSONObject get(){
//		return JSONObject;
//	}
}

