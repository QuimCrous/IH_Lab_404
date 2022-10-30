package com.example.lab402.controllers;

import com.example.lab402.models.Doctor;
import com.example.lab402.models.Patient;
import com.example.lab402.repositories.PatientRepository;
import com.example.lab402.services.interfaces.PatientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    PatientServiceInterface patientService;

    @RequestMapping(value = "/patients/from/{date1}/to/{date2}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientBy(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2){
        return patientService.getPatientBy(date1, date2);
    }

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @RequestMapping(value = "/patients/{department}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientByDoctorDepartment(@PathVariable String department) {
        return patientService.getPatientByDoctorDepartment(department);
    }

    @RequestMapping(value = "/patients/off", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientByDoctorStatus() {
        return patientService.getPatientByDoctorStatus();
    }

    @PostMapping("/patients/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient addNewPatient(@RequestBody Patient patient){
        return patientService.addNewPatient(patient);
    }

    @PutMapping("/patients/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.updatePatientInformation(id, patient);
    }
}
