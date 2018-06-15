package com.react.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.react.interfaces.Element;

@Path("/Event")
public class EventController{
	static final List<Element> elementList = new ArrayList<Element>();
	static Long counter = 1L;
	
	@GET
	@Path("/List")	
	public Response listEvents(){		
		String output = "test";
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			output = objectMapper.writeValueAsString(elementList);
			System.out.println("Output JSON : "+output);
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		}	
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("/Add")
	public Response addEvents(@QueryParam("event") String elementJson){
		System.out.println("Input JSON : "+elementJson);
		ObjectMapper mapper = new ObjectMapper();
		Element element = new Element();
		try {
			element = mapper.readValue(elementJson, Element.class);
			element.setEventId(counter++);			
			System.out.println(" Element created");			
			elementList.add(element);
			return Response.status(200).entity(counter.toString()).build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(200).entity("Error"+e.getMessage()).build();
		}		
	}
	
	@GET
	@Path("/Update")
	public Response modifyEvent(@QueryParam("event") String elementJson){
		System.out.println("Input JSON : "+elementJson);
		ObjectMapper mapper = new ObjectMapper();
		Element element = null;
		try {			
			element = mapper.readValue(elementJson, Element.class);			
			for(Element el : elementList){				
				if(el.getEventId() == element.getEventId()){
					elementList.set(elementList.indexOf(el),element);
					System.out.println(" Element updated");	
					break;
				}				
			}			
			//elementList.add(element);
			return Response.status(200).entity("success").build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(200).entity("Error"+e.getMessage()).build();
		}		
	}
	
	
	static{
		Element el1 = new Element(counter++,"1", "S", "S", "t4", "permanent");
		Element el2 = new Element(counter++,"1", "S", "S", "t4", "permanent");
		Element el3 = new Element(counter++,"1", "N", "N", "t4", "permanent");
		elementList.add(el1);
		elementList.add(el2);
		elementList.add(el3);
		System.out.println("Static Block");
	}
}
