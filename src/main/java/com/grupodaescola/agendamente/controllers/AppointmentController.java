package com.grupodaescola.agendamente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AppointmentDTO> findById(@PathVariable Integer id) {
		AppointmentDTO appointment = appointmentService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(appointment);
	}
	
	@PostMapping
	public ResponseEntity<AppointmentDTO> insert(@RequestBody AppointmentDTO appointment) {
		AppointmentDTO savedAppointment = appointmentService.insert(appointment);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		appointmentService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AppointmentDTO> update(@PathVariable Integer id, @RequestBody AppointmentDTO appointment) {
	    AppointmentDTO updatedAppointment = appointmentService.update(id, appointment);
	    return ResponseEntity.status(HttpStatus.OK).body(updatedAppointment);
	}
}
