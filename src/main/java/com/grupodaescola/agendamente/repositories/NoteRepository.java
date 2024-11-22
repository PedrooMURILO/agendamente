package com.grupodaescola.agendamente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupodaescola.agendamente.models.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {

}
