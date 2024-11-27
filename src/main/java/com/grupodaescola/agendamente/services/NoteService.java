package com.grupodaescola.agendamente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public NoteDTO findById(Integer id) {
		Optional<Note> note = noteRepository.findById(id);
		return new NoteDTO(note.get());
	}
	
	public NoteDTO insert(Note note) {
		Note savedNote = noteRepository.save(note);
		return new NoteDTO(savedNote);
	}
	
	public void delete(Integer id) {
		noteRepository.deleteById(id);
	}
	
	@Transactional
	public NoteDTO update(Integer id, Note note) {
		Note existingNote = noteRepository.getReferenceById(id);
		updateData(existingNote, note);
		return new NoteDTO(noteRepository.save(existingNote));
	}
	
	private void updateData(Note existingNote, Note note) {
		existingNote.setContent(note.getContent());
		existingNote.setTimestamp(note.getTimestamp());
	}
}
