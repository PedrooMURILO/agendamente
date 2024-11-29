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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PsychologistDTO> findById(@PathVariable Integer id) {
		PsychologistDTO psychologist = psychologistService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(psychologist);
	}
	
	@PostMapping
	public ResponseEntity<PsychologistDTO> insert(@RequestBody PsychologistDTO psychologist) {
		PsychologistDTO savedPsychologist = psychologistService.insert(psychologist);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPsychologist);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		psychologistService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PsychologistDTO> update(@PathVariable Integer id, @RequestBody PsychologistDTO psychologist) {
	    PsychologistDTO updatedPsychologist = psychologistService.update(id, psychologist);
	    return ResponseEntity.status(HttpStatus.OK).body(updatedPsychologist);
	}
}
