package com.grupodaescola.agendamente.dtos;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import com.grupodaescola.agendamente.models.Appointment;
import com.grupodaescola.agendamente.models.enums.AppointmentStatus;

public class AppointmentDTO {

	private Integer id;
	private LocalDateTime date;
	private AppointmentStatus appointmentStatus;
	
	private NoteDTO note;

	public AppointmentDTO() {
	}

	public AppointmentDTO(Appointment entity) {
		BeanUtils.copyProperties(entity, this);
		if (entity.getNote() != null) {
			this.note = new NoteDTO(entity.getNote());
		}
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

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public NoteDTO getNote() {
		return note;
	}

	public void setNote(NoteDTO note) {
		this.note = note;
	}
}
