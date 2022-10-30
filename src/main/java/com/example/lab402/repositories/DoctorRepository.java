package com.example.lab402.repositories;

import com.example.lab402.enums.Status;
import com.example.lab402.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByStatus(Status status);
    List<Doctor> findByDepartment(String department);
    List<Doctor> findByDepartmentAndStatus(String department, Status status);
}
