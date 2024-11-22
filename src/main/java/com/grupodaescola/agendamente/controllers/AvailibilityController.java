package com.grupodaescola.agendamente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupodaescola.agendamente.dtos.AvailibilityDTO;
import com.grupodaescola.agendamente.services.AvailibilityService;

@RestController
@RequestMapping(value = "/availibilitys")
public class AvailibilityController {
	
	@Autowired
	private AvailibilityService availibilityService;

	@GetMapping
	public ResponseEntity<List<AvailibilityDTO>> findAll() {
		List<AvailibilityDTO> availibilityList = availibilityService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(availibilityList);
	}
}
