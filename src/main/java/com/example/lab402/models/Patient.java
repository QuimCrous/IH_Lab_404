package com.example.lab402.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String name;
    private LocalDate localDate;
    @ManyToOne
    @JoinColumn(name = "doctor_employee_id")
    private Doctor admittedBy;


    public Patient() {
    }


    public Patient(String name, LocalDate localDate, Doctor admittedBy) {
        this.name = name;
        this.localDate = localDate;
        this.admittedBy = admittedBy;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Doctor getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Doctor admittedBy) {
        this.admittedBy = admittedBy;
    }
}
