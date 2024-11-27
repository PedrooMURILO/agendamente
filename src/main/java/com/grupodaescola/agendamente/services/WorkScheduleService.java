package com.grupodaescola.agendamente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupodaescola.agendamente.dtos.WorkScheduleDTO;
import com.grupodaescola.agendamente.models.WorkSchedule;
import com.grupodaescola.agendamente.repositories.WorkScheduleRepository;

@Service
public class WorkScheduleService {

	@Autowired
	private WorkScheduleRepository workScheduleRepository;

	public List<WorkScheduleDTO> findAll() {
		List<WorkSchedule> workScheduleList = workScheduleRepository.findAll();
		return workScheduleList.stream().map(x -> new WorkScheduleDTO(x)).toList();
	}
}
