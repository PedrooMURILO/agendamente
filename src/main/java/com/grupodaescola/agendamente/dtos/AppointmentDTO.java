package com.grupodaescola.agendamente.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.BeanUtils;

import com.grupodaescola.agendamente.models.Appointment;
import com.grupodaescola.agendamente.models.enums.AppointmentStatus;

public class AppointmentDTO {

	private Integer id;
	private LocalDate date;
	private LocalTime time;
	private AppointmentStatus appointmentStatus;
	
	private PatientMinDTO patient;
	
	private PsychologistMinDTO psychologist;

	public AppointmentDTO() {
	}

	public AppointmentDTO(Appointment entity) {
		BeanUtils.copyProperties(entity, this);
		if (entity.getPatient() != null) {
			this.patient = new PatientMinDTO(entity.getPatient());
		}
		if (entity.getPsychologist() != null) {
			this.psychologist = new PsychologistMinDTO(entity.getPsychologist());
		}
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

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public PatientMinDTO getPatient() {
		return patient;
	}

	public void setPatient(PatientMinDTO patient) {
		this.patient = patient;
	}

	public PsychologistMinDTO getPsychologist() {
		return psychologist;
	}

	public void setPsychologist(PsychologistMinDTO psychologist) {
		this.psychologist = psychologist;
	}
}
