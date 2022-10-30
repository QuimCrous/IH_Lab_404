package com.example.lab402.services.interfaces;

import com.example.lab402.models.Patient;

import java.time.LocalDate;
import java.util.List;

public interface PatientServiceInterface {
     List<Patient> getPatientBy(LocalDate date1, LocalDate date2);


     List<Patient> getAllPatients();


     Patient getPatientById(Long id);


     List<Patient> getPatientByDoctorDepartment(String department);


     List<Patient> getPatientByDoctorStatus();

     Patient addNewPatient(Patient patient);

     Patient updatePatientInformation(Long id, Patient patient);
}
