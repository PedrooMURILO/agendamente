package com.grupodaescola.agendamente.dtos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.grupodaescola.agendamente.models.Appointment;
import com.grupodaescola.agendamente.models.Patient;

public class PatientDTO {

	private Integer id;
	private String name;
	private String phone;
	private Boolean whatsapp;

	private List<AppointmentMinDTO> appointments = new ArrayList<>();

	public PatientDTO() {
	}

	public PatientDTO(Patient entity) {
		BeanUtils.copyProperties(entity, this);
		if (entity.getAppointments() != null) {
		    for (Appointment appointment : entity.getAppointments()) {
		        this.appointments.add(new AppointmentMinDTO(appointment));
		    }
		}
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

	public Boolean getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(Boolean whatsapp) {
		this.whatsapp = whatsapp;
	}

	public List<AppointmentMinDTO> getAppointments() {
		return appointments;
	}
}
