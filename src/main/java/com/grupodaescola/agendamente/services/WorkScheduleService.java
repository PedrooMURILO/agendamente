package com.grupodaescola.agendamente.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupodaescola.agendamente.dtos.WorkScheduleDTO;
import com.grupodaescola.agendamente.models.Availability;
import com.grupodaescola.agendamente.models.WorkSchedule;
import com.grupodaescola.agendamente.repositories.AvailabilityRepository;
import com.grupodaescola.agendamente.repositories.WorkScheduleRepository;
import com.grupodaescola.agendamente.services.exceptions.DatabaseException;
import com.grupodaescola.agendamente.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class WorkScheduleService {

	@Autowired
	private WorkScheduleRepository workScheduleRepository;

	@Autowired
	private AvailabilityRepository availabilityRepository;

	public List<WorkScheduleDTO> findAll() {
		List<WorkSchedule> workScheduleList = workScheduleRepository.findAll();
		return workScheduleList.stream().map(x -> new WorkScheduleDTO(x)).toList();
	}

	public WorkScheduleDTO findById(Integer id) {
		WorkSchedule workSchedule = workScheduleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
		return new WorkScheduleDTO(workSchedule);
	}

	public WorkScheduleDTO insert(WorkScheduleDTO workSchedule) {
		WorkSchedule savedWorkSchedule = new WorkSchedule();
		Availability availability = availabilityRepository.findById(workSchedule.getAvailability().getId())
				.orElseThrow(() -> new IllegalArgumentException("Availability not found"));
		BeanUtils.copyProperties(workSchedule, savedWorkSchedule);
		savedWorkSchedule.setAvailability(availability);
		savedWorkSchedule = workScheduleRepository.save(savedWorkSchedule);
		return new WorkScheduleDTO(savedWorkSchedule);
	}

	public void delete(Integer id) {
		if (!workScheduleRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		try {
			workScheduleRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	@Transactional
	public WorkScheduleDTO update(Integer id, WorkScheduleDTO workSchedule) {
		try {
			WorkSchedule existingWorkSchedule = workScheduleRepository.getReferenceById(id);
			updateData(existingWorkSchedule, workSchedule);
			return new WorkScheduleDTO(workScheduleRepository.save(existingWorkSchedule));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(WorkSchedule existingWorkSchedule, WorkScheduleDTO workSchedule) {
		existingWorkSchedule.setMorningStartTime(workSchedule.getMorningStartTime());
		existingWorkSchedule.setMorningEndTime(workSchedule.getMorningEndTime());
		existingWorkSchedule.setAfternoonStartTime(workSchedule.getAfternoonStartTime());
		existingWorkSchedule.setAfternoonEndTime(workSchedule.getAfternoonEndTime());
	}
}
