package com.grupodaescola.agendamente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupodaescola.agendamente.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
