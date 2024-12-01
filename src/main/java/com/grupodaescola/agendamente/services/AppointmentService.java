package com.grupodaescola.agendamente.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupodaescola.agendamente.dtos.AppointmentDTO;
import com.grupodaescola.agendamente.models.Appointment;
import com.grupodaescola.agendamente.models.Patient;
import com.grupodaescola.agendamente.models.Psychologist;
import com.grupodaescola.agendamente.repositories.AppointmentRepository;
import com.grupodaescola.agendamente.repositories.PatientRepository;
import com.grupodaescola.agendamente.repositories.PsychologistRepository;
import com.grupodaescola.agendamente.services.exceptions.DatabaseException;
import com.grupodaescola.agendamente.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PsychologistRepository psychologistRepository;

	public List<AppointmentDTO> findAll() {
		List<Appointment> appointmentList = appointmentRepository.findAll();
		return appointmentList.stream().map(x -> new AppointmentDTO(x)).toList();
	}

	public AppointmentDTO findById(Integer id) {
		Appointment appointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
		return new AppointmentDTO(appointment);
	}

	public AppointmentDTO insert(AppointmentDTO appointment) {
		Appointment savedAppointment = new Appointment();
		Patient patient = patientRepository.findById(appointment.getPatient().getId())
				.orElseThrow(() -> new IllegalArgumentException("Patient not found"));
		Psychologist psychologist = psychologistRepository.findById(appointment.getPsychologist().getId())
				.orElseThrow(() -> new IllegalArgumentException("Psychologist not found"));
		BeanUtils.copyProperties(appointment, savedAppointment);
		savedAppointment.setPatient(patient);
		savedAppointment.setPsychologist(psychologist);
		savedAppointment = appointmentRepository.save(savedAppointment);
		return new AppointmentDTO(savedAppointment);
	}

	public void delete(Integer id) {
		if (!appointmentRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		try {
			appointmentRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	@Transactional
	public AppointmentDTO update(Integer id, AppointmentDTO appointment) {
		try {
			Appointment existingAppointment = appointmentRepository.getReferenceById(id);
			updateData(existingAppointment, appointment);
			return new AppointmentDTO(appointmentRepository.save(existingAppointment));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Appointment existingAppointment, AppointmentDTO appointment) {
		existingAppointment.setAppointmentStatus(appointment.getAppointmentStatus());
		existingAppointment.setIsActive(appointment.getIsActive());
	}
}
