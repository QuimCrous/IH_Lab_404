package com.example.lab402;

import com.example.lab402.enums.Status;
import com.example.lab402.models.Doctor;
import com.example.lab402.models.Patient;
import com.example.lab402.repositories.DoctorRepository;
import com.example.lab402.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Lab402Application implements CommandLineRunner {
	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(Lab402Application.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		doctorRepository.saveAll(List.of(
			new Doctor(356712L,"cardiology","Alonso Flores", Status.ON_CALL),
			new Doctor(564134L,"immunology","Sam Ortega", Status.ON),
			new Doctor(761527L,"cardiology","German Ruiz", Status.OFF),
			new Doctor(166552L,"pulmonary","Maria Lin", Status.ON),
			new Doctor(156545L,"orthopaedic","Paolo Rodriguez", Status.ON_CALL),
			new Doctor(172456L,"psychiatric","John Paul Armes", Status.OFF)
		));
		Doctor doctor1 = doctorRepository.findById(564134L).get();
		Doctor doctor2 = doctorRepository.findById(356712L).get();
		Doctor doctor3 = doctorRepository.findById(761527L).get();
		Doctor doctor4 = doctorRepository.findById(172456L).get();

		patientRepository.saveAll(List.of(
			new Patient("Jaime Jordan",LocalDate.of(1984,03,02),doctor1),
			new Patient("Marian Garcia",LocalDate.of(1972,01,12),doctor1),
			new Patient("Julia Dusterdieck",LocalDate.of(1954,06,11),doctor2),
			new Patient("Steve McDuck",LocalDate.of(1931,11,10),doctor3),
			new Patient("Jaime Jordan",LocalDate.of(1999,02,15),doctor4)

		));
	}
}
