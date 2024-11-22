package com.grupodaescola.agendamente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupodaescola.agendamente.dtos.PsychologistDTO;
import com.grupodaescola.agendamente.models.Psychologist;
import com.grupodaescola.agendamente.repositories.PsychologistRepository;

@Service
public class PsychologistService {

	@Autowired
	private PsychologistRepository psychologistRepository;

	public List<PsychologistDTO> findAll() {
		List<Psychologist> psychologistList = psychologistRepository.findAll();
		return psychologistList.stream().map(x -> new PsychologistDTO(x)).toList();
	}
}
