package com.grupodaescola.agendamente.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.grupodaescola.agendamente.models.Patient;
import com.grupodaescola.agendamente.repositories.PatientRepository;

@Component
public class DataSeeder implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Patient p1 = new Patient(null, "Pedro Murilo", "(17) 99999-9999", true);
		Patient p2 = new Patient(null, "Bianca Veronez", "(17) 99999-9999", false);
		Patient p3 = new Patient(null, "Alice Oliveira", "(17) 99999-9999", false);
		Patient p4 = new Patient(null, "Giovanna Peres", "(17) 99999-9999", true);
		
		patientRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
	}
}
