package com.grupodaescola.agendamente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupodaescola.agendamente.models.Availibility;

public interface AvailibilityRepository extends JpaRepository<Availibility, Integer> {

}
