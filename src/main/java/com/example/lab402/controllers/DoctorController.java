package com.example.lab402.controllers;

import com.example.lab402.enums.Status;
import com.example.lab402.models.Doctor;
import com.example.lab402.models.Patient;
import com.example.lab402.repositories.DoctorRepository;
import com.example.lab402.services.interfaces.DoctorServiceInterface;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
import java.util.Optional;
@RestController
public class DoctorController {
    @Autowired
    DoctorServiceInterface doctorService;


    @RequestMapping(value = "/doctor/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getAllDoctors(@RequestParam Optional<Status> status, @RequestParam Optional<String> department){
        return doctorService.getAllDoctors(status, department);
    }

    @PostMapping("/doctors/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor addNewDoctor(@RequestBody Doctor doctor){
        return doctorService.addNewDoctor(doctor);
    }
    //A tener en cuenta, cuando utilizo el postman en RAW y text porque json me da errores
    @PatchMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor changeDoctorStatus(@PathVariable Long id, @RequestBody String status){
        return doctorService.changeDoctorStatus(id, Status.valueOf(status));
    }

    @PatchMapping("/doctors/change-department/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor changeDoctorDepartment(@PathVariable Long id, @RequestBody String department){
        return doctorService.changeDoctorDepartment(id, department);
    }
}
