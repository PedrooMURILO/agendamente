package com.grupodaescola.agendamente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupodaescola.agendamente.models.WorkSchedule;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Integer> {

}
