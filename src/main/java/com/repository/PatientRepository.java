package com.repository;

import com.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAllBySex(String sex);
    List<Patient> findAllByAge(String age);
}
