package com.grupodaescola.agendamente.dtos;

import com.grupodaescola.agendamente.models.Patient;

public class PatientMinDTO {

	private Integer id;
	private String name;
	private String whatsapp;
	
	public PatientMinDTO() {
	}
	
	public PatientMinDTO(Patient entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.whatsapp = entity.getWhatsapp();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}
}
