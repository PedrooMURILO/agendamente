package com.grupodaescola.agendamente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupodaescola.agendamente.dtos.NoteDTO;
import com.grupodaescola.agendamente.models.Note;
import com.grupodaescola.agendamente.repositories.NoteRepository;

@Service
public class NoteService {
	
	@Autowired
	private NoteRepository noteRepository;
	
	public List<NoteDTO> findAll() {
		List<Note> noteList = noteRepository.findAll();
		return noteList.stream().map(x -> new NoteDTO(x)).toList();
	}
}
