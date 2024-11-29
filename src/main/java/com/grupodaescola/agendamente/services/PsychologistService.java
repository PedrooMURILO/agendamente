package com.grupodaescola.agendamente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public PsychologistDTO findById(Integer id) {
		Optional<Psychologist> psychologist = psychologistRepository.findById(id);
		return new PsychologistDTO(psychologist.get());
	}
	
	public PsychologistDTO insert(PsychologistDTO psychologist) {
		Psychologist savedPsychologist = new Psychologist();
		BeanUtils.copyProperties(psychologist, savedPsychologist);
		savedPsychologist = psychologistRepository.save(savedPsychologist);
		return new PsychologistDTO(savedPsychologist);
	}
	
	public void delete(Integer id) {
		psychologistRepository.deleteById(id);
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
