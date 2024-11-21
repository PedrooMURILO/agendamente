package com.grupodaescola.agendamente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupodaescola.agendamente.models.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
