package com.grupodaescola.agendamente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupodaescola.agendamente.models.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {

}
