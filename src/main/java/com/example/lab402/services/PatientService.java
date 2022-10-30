package com.example.lab402.services;

import com.example.lab402.models.Patient;
import com.example.lab402.repositories.PatientRepository;
import com.example.lab402.services.interfaces.PatientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService implements PatientServiceInterface {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getPatientBy(LocalDate date1, LocalDate date2){
        return patientRepository.findByLocalDateBetween(date1,date2);
    }


    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }


    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).get();
    }


    public List<Patient> getPatientByDoctorDepartment(String department) {
        return patientRepository.findByDoctorDepartment(department);
    }


    public List<Patient> getPatientByDoctorStatus() {
        return patientRepository.findByDoctorStatus();
    }

    public Patient addNewPatient(Patient patient) {
        return patientRepository.save(patient);
    }


    public Patient updatePatientInformation(Long id, Patient patient) {
        if (patientRepository.findById(id).isPresent()){
            patient.setPatientId(id);
            return patientRepository.save(patient);
        }

        return null;
    }
}
