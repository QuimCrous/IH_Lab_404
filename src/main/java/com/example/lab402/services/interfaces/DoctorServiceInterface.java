package com.example.lab402.services.interfaces;

import com.example.lab402.enums.Status;
import com.example.lab402.models.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorServiceInterface {

    Doctor getDoctorById(Long id);
    List<Doctor> getAllDoctors(Optional<Status> status, Optional<String> department);

    Doctor addNewDoctor(Doctor doctor);

    Doctor changeDoctorStatus(Long id, Status status);
    Doctor changeDoctorDepartment(Long id, String department);
}
