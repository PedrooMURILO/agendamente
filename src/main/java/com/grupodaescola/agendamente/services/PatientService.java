package com.grupodaescola.agendamente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public PatientDTO update(Integer id, Patient patient) {
		Patient existingPatient = patientRepository.getReferenceById(id);
		updateData(existingPatient, patient);
		return new PatientDTO(patientRepository.save(existingPatient));
	}
	
	private void updateData(Patient existingPatient, Patient patient) {
		existingPatient.setName(patient.getName());
		existingPatient.setWhatsapp(patient.getWhatsapp());
	}
}
