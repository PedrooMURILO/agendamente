package com.grupodaescola.agendamente.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupodaescola.agendamente.dtos.PsychologistDTO;
import com.grupodaescola.agendamente.models.Psychologist;
import com.grupodaescola.agendamente.repositories.PsychologistRepository;
import com.grupodaescola.agendamente.services.exceptions.DatabaseException;
import com.grupodaescola.agendamente.services.exceptions.ResourceNotFoundException;

@Service
public class PsychologistService {

	@Autowired
	private PsychologistRepository psychologistRepository;

	public List<PsychologistDTO> findAll() {
		List<Psychologist> psychologistList = psychologistRepository.findAll();
		return psychologistList.stream().map(x -> new PsychologistDTO(x)).toList();
	}
	
	public PsychologistDTO findById(Integer id) {
		Psychologist psychologist = psychologistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return new PsychologistDTO(psychologist);
	}
	
	public PsychologistDTO insert(PsychologistDTO psychologist) {
		Psychologist savedPsychologist = new Psychologist();
		BeanUtils.copyProperties(psychologist, savedPsychologist);
		savedPsychologist = psychologistRepository.save(savedPsychologist);
		return new PsychologistDTO(savedPsychologist);
	}
	
	public void delete(Integer id) {
		if (!psychologistRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);			
		}
		try {
			psychologistRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	@Transactional
	public PsychologistDTO update(Integer id, PsychologistDTO psychologist) {
		Psychologist existingPsychologist = psychologistRepository.getReferenceById(id);
		updateData(existingPsychologist, psychologist);
		return new PsychologistDTO(psychologistRepository.save(existingPsychologist));
	}
	
	private void updateData(Psychologist existingPsychologist, PsychologistDTO psychologist) {
		existingPsychologist.setName(psychologist.getName());
		existingPsychologist.setBusinessName(psychologist.getBusinessName());;
		existingPsychologist.setPhone(psychologist.getPhone());;
		existingPsychologist.setEmail(psychologist.getEmail());
		existingPsychologist.setPassword(psychologist.getPassword());
		existingPsychologist.setProfessionalLicense(psychologist.getProfessionalLicense());
		
	}
}
