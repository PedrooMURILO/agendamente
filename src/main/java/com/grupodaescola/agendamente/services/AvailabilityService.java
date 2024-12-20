package com.grupodaescola.agendamente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupodaescola.agendamente.dtos.AvailabilityDTO;
import com.grupodaescola.agendamente.models.Availability;
import com.grupodaescola.agendamente.models.Psychologist;
import com.grupodaescola.agendamente.repositories.AvailabilityRepository;
import com.grupodaescola.agendamente.repositories.PsychologistRepository;
import com.grupodaescola.agendamente.services.exceptions.DatabaseException;
import com.grupodaescola.agendamente.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AvailabilityService {

	@Autowired
	private AvailabilityRepository availabilityRepository;

	@Autowired
	private PsychologistRepository psychologistRepository;

	public List<AvailabilityDTO> findAll() {
		List<Availability> availabilityList = availabilityRepository.findAll();
		return availabilityList.stream().map(x -> new AvailabilityDTO(x)).toList();
	}

	public AvailabilityDTO findById(Integer id) {
		Availability availability = availabilityRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));
		return new AvailabilityDTO(availability);
	}

	public AvailabilityDTO insert(AvailabilityDTO availability) {
		Availability savedAvailability = new Availability();

		Psychologist psychologist = psychologistRepository.findById(availability.getPsychologist().getId())
				.orElseThrow(() -> new IllegalArgumentException("Psychologist not found"));

		savedAvailability.setId(availability.getId());
		savedAvailability.setDuration(availability.getDuration());
		savedAvailability.setPsychologist(psychologist);
		savedAvailability = availabilityRepository.save(savedAvailability);
		return new AvailabilityDTO(savedAvailability);
	}

	public void delete(Integer id) {
		if (!availabilityRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		try {
			availabilityRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	@Transactional
	public AvailabilityDTO update(Integer id, AvailabilityDTO availability) {
		try {
			Availability existingAvailability = availabilityRepository.getReferenceById(id);
			updateData(existingAvailability, availability);
			return new AvailabilityDTO(availabilityRepository.save(existingAvailability));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Availability existingAvailability, AvailabilityDTO availability) {
		existingAvailability.setDuration(availability.getDuration());
	}
}
