package com.grupodaescola.agendamente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupodaescola.agendamente.models.Psychologist;

public interface PsychologistRepository extends JpaRepository<Psychologist, Integer> {

}
