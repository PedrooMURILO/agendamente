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

import com.grupodaescola.agendamente.dtos.AvailabilityDTO;
import com.grupodaescola.agendamente.services.AvailabilityService;

@RestController
@RequestMapping(value = "/availabilitys")
public class AvailabilityController {
	
	@Autowired
	private AvailabilityService availabilityService;

	@GetMapping
	public ResponseEntity<List<AvailabilityDTO>> findAll() {
		List<AvailabilityDTO> availabilityList = availabilityService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(availabilityList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AvailabilityDTO> findById(@PathVariable Integer id) {
		AvailabilityDTO availability = availabilityService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(availability);
	}
	
	@PostMapping
	public ResponseEntity<AvailabilityDTO> insert(@RequestBody AvailabilityDTO availability) {
		AvailabilityDTO savedAvailability = availabilityService.insert(availability);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedAvailability);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		availabilityService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AvailabilityDTO> update(@PathVariable Integer id, @RequestBody AvailabilityDTO availability) {
	    AvailabilityDTO updatedAvailability = availabilityService.update(id, availability);
	    return ResponseEntity.status(HttpStatus.OK).body(updatedAvailability);
	}
}
