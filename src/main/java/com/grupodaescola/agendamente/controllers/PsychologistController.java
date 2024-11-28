package com.grupodaescola.agendamente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupodaescola.agendamente.dtos.PsychologistDTO;
import com.grupodaescola.agendamente.services.PsychologistService;

@RestController
@RequestMapping(value = "/psychologists")
public class PsychologistController {

	@Autowired
	private PsychologistService psychologistService;
	
	@GetMapping
	public ResponseEntity<List<PsychologistDTO>> findAll() {
		List<PsychologistDTO> psychologistList = psychologistService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(psychologistList);
	}
}
