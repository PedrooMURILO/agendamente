package com.grupodaescola.agendamente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupodaescola.agendamente.dtos.PatientDTO;
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
}