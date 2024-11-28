package com.grupodaescola.agendamente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
