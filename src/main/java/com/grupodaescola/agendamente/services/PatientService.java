package com.grupodaescola.agendamente.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupodaescola.agendamente.dtos.PatientDTO;
import com.grupodaescola.agendamente.models.Patient;
import com.grupodaescola.agendamente.repositories.PatientRepository;
import com.grupodaescola.agendamente.services.exceptions.DatabaseException;
import com.grupodaescola.agendamente.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public List<PatientDTO> findAll() {
		List<Patient> list = patientRepository.findAll();
		return list.stream().map(x -> new PatientDTO(x)).toList();
	}

	public PatientDTO findById(Integer id) {
		Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return new PatientDTO(patient);
	}

	public PatientDTO insert(PatientDTO patient) {
		Patient savedPatient = new Patient();
		BeanUtils.copyProperties(patient, savedPatient);
		savedPatient = patientRepository.save(savedPatient);
		return new PatientDTO(savedPatient);
	}

	public void delete(Integer id) {
		if (!patientRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		try {
			patientRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	@Transactional
	public PatientDTO update(Integer id, PatientDTO patient) {
		try {
			Patient existingPatient = patientRepository.getReferenceById(id);
			updateData(existingPatient, patient);
			return new PatientDTO(patientRepository.save(existingPatient));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Patient existingPatient, PatientDTO patient) {
		existingPatient.setName(patient.getName());
		existingPatient.setWhatsapp(patient.getWhatsapp());
	}
}
