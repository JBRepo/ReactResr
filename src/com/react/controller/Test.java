package com.react.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.react.interfaces.Element;

public class Test {

	public static void main(String[] args) {
		Element el1 = new Element(1L,"t1", "t2", "t3", "t4", "t5");
		Element el2 = new Element(2L,"t1", "t2", "t3", "t4", "t5");
		Element el3 = new Element(3L,"t1", "t2", "t3", "t4", "t5");
		List elementList = new ArrayList<String>();
		elementList.add(el1);
		elementList.add(el2);
		elementList.add(el3);
		String arrayToJson = "test";
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			arrayToJson = objectMapper.writeValueAsString(elementList);
			System.out.println("JSON : "+arrayToJson);
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		}
		String jsonString = "{\"eventType\":\"t1\",\"dipendant\":\"t2\",\"observazione\":\"t3\",\"descrizioneEvento\":\"t4\",\"soln\":\"t5\"}";
		ObjectMapper mapper = new ObjectMapper();
		Element element = null;
		try {
			element = mapper.readValue(jsonString, Element.class);
			System.out.println(" Element created"+ element.getDescrizioneEvento());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
