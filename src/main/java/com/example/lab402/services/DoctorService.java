package com.example.lab402.services;

import com.example.lab402.enums.Status;
import com.example.lab402.models.Doctor;
import com.example.lab402.repositories.DoctorRepository;
import com.example.lab402.services.interfaces.DoctorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService implements DoctorServiceInterface {

    @Autowired
    DoctorRepository doctorRepository;



    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).get();
    }

    public List<Doctor> getAllDoctors(Optional<Status> status, Optional<String> department){

        if (status.isPresent() && department.isPresent())
            return doctorRepository.findByDepartmentAndStatus(department.get(), status.get());
        if (status.isPresent())
            return doctorRepository.findByStatus(status.get());
        if (department.isPresent())
            return doctorRepository.findByDepartment(department.get());
        return doctorRepository.findAll();
    }


    public Doctor addNewDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }


    public Doctor changeDoctorStatus(Long id, Status status) {
        if (doctorRepository.existsById(id)){
            Doctor doctor1 = doctorRepository.findById(id).get();
            doctor1.setStatus(status);
            return doctorRepository.save(doctor1);
        }
        return null;
    }


    public Doctor changeDoctorDepartment(Long id, String department) {
        if (doctorRepository.existsById(id)){
            Doctor doctor1 = doctorRepository.findById(id).get();
            doctor1.setDepartment(department);
            return doctorRepository.save(doctor1);
        }
        return null;
    }
}
