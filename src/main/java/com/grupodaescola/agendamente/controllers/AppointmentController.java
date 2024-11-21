package com.grupodaescola.agendamente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupodaescola.agendamente.dtos.AppointmentDTO;
import com.grupodaescola.agendamente.services.AppointmentService;

@RestController
@RequestMapping(value = "/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping
	public ResponseEntity<List<AppointmentDTO>> findAll() {
		List<AppointmentDTO> appointmentList = appointmentService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(appointmentList);
	}
}
