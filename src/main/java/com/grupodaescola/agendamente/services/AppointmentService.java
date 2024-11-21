package com.grupodaescola.agendamente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupodaescola.agendamente.dtos.AppointmentDTO;
import com.grupodaescola.agendamente.models.Appointment;
import com.grupodaescola.agendamente.repositories.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	public List<AppointmentDTO> findAll() {
		List<Appointment> appointmentList = appointmentRepository.findAll();
		return appointmentList.stream().map(x -> new AppointmentDTO(x)).toList();
	}
}
