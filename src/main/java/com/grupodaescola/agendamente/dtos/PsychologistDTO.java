package com.grupodaescola.agendamente.dtos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grupodaescola.agendamente.models.Appointment;
import com.grupodaescola.agendamente.models.Psychologist;

public class PsychologistDTO {

	private Integer id;
	private String name;
	private String businessName;
	private String phone;
	private String email;

	@JsonIgnore
	private String password;
	private String professionalLicense;
	
	private AvailabilityDTO availability;
	
	private List<AppointmentMinDTO> appointments = new ArrayList<>();

	public PsychologistDTO() {
	}
	
	public PsychologistDTO(Psychologist entity) {
		BeanUtils.copyProperties(entity, this);
		if (entity.getAvailability() != null) {
            this.availability = new AvailabilityDTO(entity.getAvailability());
        }
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfessionalLicense() {
		return professionalLicense;
	}

	public void setProfessionalLicense(String professionalLicense) {
		this.professionalLicense = professionalLicense;
	}

	public AvailabilityDTO getavailability() {
		return availability;
	}

	public void setavailability(AvailabilityDTO availability) {
		this.availability = availability;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public List<AppointmentMinDTO> getAppointments() {
		return appointments;
	}
}
