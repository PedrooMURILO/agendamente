package com.grupodaescola.agendamente.config;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.grupodaescola.agendamente.models.Appointment;
import com.grupodaescola.agendamente.models.Availibility;
import com.grupodaescola.agendamente.models.Note;
import com.grupodaescola.agendamente.models.Patient;
import com.grupodaescola.agendamente.models.Psychologist;
import com.grupodaescola.agendamente.models.enums.AppointmentStatus;
import com.grupodaescola.agendamente.repositories.AppointmentRepository;
import com.grupodaescola.agendamente.repositories.NoteRepository;
import com.grupodaescola.agendamente.repositories.PatientRepository;
import com.grupodaescola.agendamente.repositories.PsychologistRepository;

@Component
public class DataSeeder implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private PsychologistRepository psychologistRepository;
	
	// @Autowired
	// private AvailibilityRepository availibilityRepository;
	
	@Autowired
	private NoteRepository noteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Patient p1 = new Patient(null, "Pedro Murilo", "(17) 99999-9999", true);
		Patient p2 = new Patient(null, "Bianca Veronez", "(17) 99999-9999", false);
		Patient p3 = new Patient(null, "Alice Oliveira", "(17) 99999-9999", false);
		Patient p4 = new Patient(null, "Giovanna Peres", "(17) 99999-9999", true);
		patientRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		Appointment a1 = new Appointment(null, LocalDateTime.now(), AppointmentStatus.COMPLETED);	
		appointmentRepository.saveAll(Arrays.asList(a1));
		
		Availibility av1 = new Availibility(null, LocalTime.NOON, LocalTime.MAX, Duration.ofMinutes(30));
		Psychologist psi1 = new Psychologist(null, "Doutora Bianca", "(17) 99999-9999", "biapsi@gmail.com", "123456", "06/123456", av1);		
		
		// availibilityRepository.saveAll(Arrays.asList(av1));
		psychologistRepository.saveAll(Arrays.asList(psi1));
		
		Note n1 = new Note(null, "O cara tem depressão", LocalDateTime.now());
		noteRepository.saveAll(Arrays.asList(n1));
	}
}
