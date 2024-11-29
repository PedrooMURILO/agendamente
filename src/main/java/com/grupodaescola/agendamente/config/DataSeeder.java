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
import com.grupodaescola.agendamente.models.Availability;
import com.grupodaescola.agendamente.models.Patient;
import com.grupodaescola.agendamente.models.Psychologist;
import com.grupodaescola.agendamente.models.WorkSchedule;
import com.grupodaescola.agendamente.models.enums.AppointmentStatus;
import com.grupodaescola.agendamente.repositories.AppointmentRepository;
import com.grupodaescola.agendamente.repositories.AvailabilityRepository;
import com.grupodaescola.agendamente.repositories.PatientRepository;
import com.grupodaescola.agendamente.repositories.PsychologistRepository;
import com.grupodaescola.agendamente.repositories.WorkScheduleRepository;

@Component
public class DataSeeder implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private PsychologistRepository psychologistRepository;
	
	@Autowired
	private AvailabilityRepository availabilityRepository;
	
	@Autowired
	private WorkScheduleRepository workScheduleRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Patient p1 = new Patient(null, "Pedro Murilo", "(17) 99999-9999");
		Patient p2 = new Patient(null, "Bianca Veronez", "(17) 99999-9999");
		Patient p3 = new Patient(null, "Alice Oliveira", "(17) 99999-9999");
		Patient p4 = new Patient(null, "Giovanna Peres", "(17) 99999-9999");
		patientRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

		Psychologist psi1 = new Psychologist(null, "Doutora Bianca", "Bianca Cuida da Mente", "(17) 99999-9999", "biapsi@gmail.com", "123456", "06/123456");
		psychologistRepository.save(psi1);

		Availability av1 = new Availability(null, Duration.ofMinutes(30), psi1);
		availabilityRepository.saveAll(Arrays.asList(av1));
		
		WorkSchedule w1 = new WorkSchedule(null, DayOfWeek.TUESDAY, LocalTime.of(8, 0), LocalTime.of(11, 0), LocalTime.of(13, 0), LocalTime.of(18, 0), av1);
		WorkSchedule w2 = new WorkSchedule(null, DayOfWeek.THURSDAY, LocalTime.of(8, 0), LocalTime.of(11, 0), LocalTime.of(13, 0), LocalTime.of(18, 0), av1);
		WorkSchedule w3 = new WorkSchedule(null, DayOfWeek.SATURDAY, LocalTime.of(8, 0), LocalTime.of(11, 0), LocalTime.of(13, 0), LocalTime.of(18, 0), av1);
		workScheduleRepository.saveAll(Arrays.asList(w1, w2, w3));
		
		Appointment a1 = new Appointment(null, LocalDate.of(2024, 12, 12), LocalTime.of(10, 30), AppointmentStatus.COMPLETED, true, p1, psi1);
		appointmentRepository.save(a1);
		
	}
}
