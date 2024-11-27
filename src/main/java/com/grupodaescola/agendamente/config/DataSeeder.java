package com.grupodaescola.agendamente.config;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.grupodaescola.agendamente.models.Appointment;
import com.grupodaescola.agendamente.models.Availibility;
import com.grupodaescola.agendamente.models.Patient;
import com.grupodaescola.agendamente.models.Psychologist;
import com.grupodaescola.agendamente.models.WorkSchedule;
import com.grupodaescola.agendamente.models.enums.AppointmentStatus;
import com.grupodaescola.agendamente.repositories.AppointmentRepository;
import com.grupodaescola.agendamente.repositories.AvailibilityRepository;
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
	
	@Autowired
	private AvailibilityRepository availibilityRepository;
	
	// @Autowired
	// private WorkScheduleRepository workScheduleRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Patient p1 = new Patient(null, "Pedro Murilo", "(17) 99999-9999");
		Patient p2 = new Patient(null, "Bianca Veronez", "(17) 99999-9999");
		Patient p3 = new Patient(null, "Alice Oliveira", "(17) 99999-9999");
		Patient p4 = new Patient(null, "Giovanna Peres", "(17) 99999-9999");
		patientRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		WorkSchedule w1 = new WorkSchedule(null, DayOfWeek.TUESDAY, LocalTime.of(8, 00), LocalTime.of(11, 00), LocalTime.of(13, 00), LocalTime.of(18, 00));
		WorkSchedule w2 = new WorkSchedule(null, DayOfWeek.THURSDAY, LocalTime.of(8, 00), LocalTime.of(11, 00), LocalTime.of(13, 00), LocalTime.of(18, 00));
		WorkSchedule w3 = new WorkSchedule(null, DayOfWeek.SATURDAY, LocalTime.of(8, 00), LocalTime.of(11, 00), LocalTime.of(13, 00), LocalTime.of(18, 00));	
		
		Psychologist psi1 = new Psychologist(null, "Doutora Bianca", "Bianca Cuida da Mente", "(17) 99999-9999", "biapsi@gmail.com", "123456", "06/123456");		
		
		Availibility av1 = new Availibility(null, Duration.ofMinutes(30), psi1);
		av1.addSchedule(w1);
		av1.addSchedule(w2);
		av1.addSchedule(w3);
		
		availibilityRepository.saveAll(Arrays.asList(av1));
		
		psi1.setAvailibility(av1);
		psychologistRepository.saveAll(Arrays.asList(psi1));
		
		Appointment a1 = new Appointment(null, LocalDate.of(2024, 12, 12), LocalTime.of(10, 30), AppointmentStatus.COMPLETED, true, p1, psi1);	
		appointmentRepository.saveAll(Arrays.asList(a1));
		
	}
}
