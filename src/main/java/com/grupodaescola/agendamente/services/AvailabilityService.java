package com.grupodaescola.agendamente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupodaescola.agendamente.dtos.AvailabilityDTO;
import com.grupodaescola.agendamente.models.Availability;
import com.grupodaescola.agendamente.repositories.AvailabilityRepository;

@Service
public class AvailabilityService {
	
	@Autowired
	private AvailabilityRepository availabilityRepository;

	public List<AvailabilityDTO> findAll() {
		List<Availability> availabilityList = availabilityRepository.findAll();
		return availabilityList.stream().map(x -> new AvailabilityDTO(x)).toList();
	}
}
