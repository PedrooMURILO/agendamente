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

import com.grupodaescola.agendamente.dtos.NoteDTO;
import com.grupodaescola.agendamente.models.Note;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<NoteDTO> findById(@PathVariable Integer id) {
		NoteDTO note = noteService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(note);
	}
	
	@PostMapping
	public ResponseEntity<NoteDTO> insert(@RequestBody Note note) {
		NoteDTO savedNote = noteService.insert(note);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedNote);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		noteService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<NoteDTO> update(@PathVariable Integer id, @RequestBody Note note) {
	    NoteDTO updatedNote = noteService.update(id, note);
	    return ResponseEntity.status(HttpStatus.OK).body(updatedNote);
	}
}
