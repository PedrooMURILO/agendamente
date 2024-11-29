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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WorkScheduleDTO> findById(@PathVariable Integer id) {
		WorkScheduleDTO workSchedule = workScheduleService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(workSchedule);
	}
	
	@PostMapping
	public ResponseEntity<WorkScheduleDTO> insert(@RequestBody WorkScheduleDTO workSchedule) {
		WorkScheduleDTO savedWorkSchedule = workScheduleService.insert(workSchedule);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedWorkSchedule);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		workScheduleService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<WorkScheduleDTO> update(@PathVariable Integer id, @RequestBody WorkScheduleDTO workSchedule) {
	    WorkScheduleDTO updatedWorkSchedule = workScheduleService.update(id, workSchedule);
	    return ResponseEntity.status(HttpStatus.OK).body(updatedWorkSchedule);
	}
}
