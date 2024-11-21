package com.grupodaescola.agendamente.dtos;

import org.springframework.beans.BeanUtils;

import com.grupodaescola.agendamente.models.Patient;

public class PatientDTO {

	private Integer id;
	private String name;
	private String phone;
	private boolean whatsapp;
	
	public PatientDTO() {
	}
	
	public PatientDTO(Patient entity) {
		BeanUtils.copyProperties(entity, this);
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(boolean whatsapp) {
		this.whatsapp = whatsapp;
	}
}
