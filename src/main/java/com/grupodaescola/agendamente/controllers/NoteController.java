package com.grupodaescola.agendamente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupodaescola.agendamente.dtos.NoteDTO;
import com.grupodaescola.agendamente.services.NoteService;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@GetMapping
	public ResponseEntity<List<NoteDTO>> findAll() {
		List<NoteDTO> noteList = noteService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(noteList);
	}
}
