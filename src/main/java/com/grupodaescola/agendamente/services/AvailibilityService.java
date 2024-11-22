package com.grupodaescola.agendamente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupodaescola.agendamente.dtos.AvailibilityDTO;
import com.grupodaescola.agendamente.models.Availibility;
import com.grupodaescola.agendamente.repositories.AvailibilityRepository;

@Service
public class AvailibilityService {
	
	@Autowired
	private AvailibilityRepository availibilityRepository;

	public List<AvailibilityDTO> findAll() {
		List<Availibility> availibilityList = availibilityRepository.findAll();
		return availibilityList.stream().map(x -> new AvailibilityDTO(x)).toList();
	}
}
