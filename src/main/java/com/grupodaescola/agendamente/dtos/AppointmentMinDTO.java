package com.grupodaescola.agendamente.dtos;

import java.time.LocalDateTime;

import com.grupodaescola.agendamente.models.Appointment;

public class AppointmentMinDTO {

	private Integer id;
	private LocalDateTime date;
	
	public AppointmentMinDTO() {
	}
	
	public AppointmentMinDTO(Appointment entity) {
		this.id = entity.getId();
		this.date = entity.getDate();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
}
