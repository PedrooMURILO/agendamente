package com.grupodaescola.agendamente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupodaescola.agendamente.dtos.PatientDTO;
import com.grupodaescola.agendamente.models.Patient;
import com.grupodaescola.agendamente.services.PatientService;

@RestController
@RequestMapping(value = "/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public ResponseEntity<List<PatientDTO>> findAll() {
		List<PatientDTO> list = patientService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PatientDTO> findById(@PathVariable Integer id) {
		PatientDTO patient = patientService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(patient);
	}
	
	@PostMapping
	public ResponseEntity<PatientDTO> insert(@RequestBody Patient patient) {
		PatientDTO savedPatient = patientService.insert(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		patientService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
	}
}
