package com.react.interfaces;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Element implements Serializable {
	
	@JsonProperty(value = "eventId")
	private Long eventId;
	@JsonProperty(value = "eventType")
	private String  eventType;
	@JsonProperty(value = "dipendant")
	private String  dipendant;
	@JsonProperty(value = "observazione")
	private String  observazione;
	@JsonProperty(value = "descrizioneEvento")
	private String  descrizioneEvento;
	@JsonProperty(value = "soln")
	private String  soln;
	
	public Element(){
		
	}
	public Element(Long a, String b, String c, String d, String e, String f){
		this.eventId =a;
		this.eventType =b;
		this.dipendant =c;
		this.observazione = d;
		this.descrizioneEvento = e;
		this.soln = f;		
	}

	
	
	
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getDipendant() {
		return dipendant;
	}

	public void setDipendant(String dipendant) {
		this.dipendant = dipendant;
	}

	public String getObservazione() {
		return observazione;
	}

	public void setObservazione(String observazione) {
		this.observazione = observazione;
	}

	public String getDescrizioneEvento() {
		return descrizioneEvento;
	}

	public void setDescrizioneEvento(String descrizioneEvento) {
		this.descrizioneEvento = descrizioneEvento;
	}

	public String getSoln() {
		return soln;
	}

	public void setSoln(String soln) {
		this.soln = soln;
	}
	
	
	
	

}
