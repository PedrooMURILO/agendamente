package com.grupodaescola.agendamente.services;

import java.util.List;
import java.util.Optional;

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
	
	public PatientDTO findById(Integer id) {
		Optional<Patient> patient = patientRepository.findById(id);
		return new PatientDTO(patient.get());
	}
	
	public PatientDTO insert(Patient patient) {
		Patient savedPatient = patientRepository.save(patient);
		return new PatientDTO(savedPatient);
	}
	
	public void delete(Integer id) {
		patientRepository.deleteById(id);
	}
}
