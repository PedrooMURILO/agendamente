package com.grupodaescola.agendamente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupodaescola.agendamente.dtos.PatientDTO;
import com.grupodaescola.agendamente.models.Patient;
import com.grupodaescola.agendamente.repositories.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	public List<PatientDTO> findAll() {
		List<Patient> list = patientRepository.findAll();
		return list.stream().map(x -> new PatientDTO(x)).toList();
	}
}