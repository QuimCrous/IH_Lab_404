package com.example.lab402.repositories;

import com.example.lab402.enums.Status;
import com.example.lab402.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByLocalDateBetween(LocalDate date1, LocalDate date2);
    @Query("SELECT pa FROM Patient pa JOIN pa.admittedBy doc WHERE doc.department LIKE :department")
    List<Patient> findByDoctorDepartment(String department);
    @Query("SELECT pa FROM Patient pa JOIN pa.admittedBy doc WHERE doc.status LIKE 'OFF'")
    List<Patient> findByDoctorStatus();
}
