package com.grupodaescola.agendamente.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.grupodaescola.agendamente.models.Appointment;

public class AppointmentMinDTO {

	private Integer id;
	private LocalDate date;
	private LocalTime time;
	
	public AppointmentMinDTO() {
	}
	
	public AppointmentMinDTO(Appointment entity) {
		this.id = entity.getId();
		this.date = entity.getDate();
		this.time = entity.getTime();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}	
}