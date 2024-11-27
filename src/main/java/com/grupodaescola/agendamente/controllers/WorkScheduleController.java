package com.grupodaescola.agendamente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupodaescola.agendamente.dtos.WorkScheduleDTO;
import com.grupodaescola.agendamente.services.WorkScheduleService;

@RestController
@RequestMapping(value = "/works-schedules")
public class WorkScheduleController {

	@Autowired
	private WorkScheduleService workScheduleService;

	@GetMapping
	public ResponseEntity<List<WorkScheduleDTO>> findAll() {
		List<WorkScheduleDTO> workScheduleList = workScheduleService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(workScheduleList);
	}
}
