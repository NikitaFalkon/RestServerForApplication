package com.repository;

import com.model.Age;
import com.model.Patient;
import com.model.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAllBySex(Sex sex);
    List<Patient> findAllByAge(Age age);
    List<Patient> findAllBySexAndAge(Sex sex, Age age);
    @Query(value = "SELECT AVG(e.hemoglobin) FROM Patient e WHERE e.sex='Man' and e.age='Child'")
    Integer findHemoglobin();
    @Query(value = "SELECT AVG(e.erythrocytes) FROM Patient e WHERE e.sex='Man' and e.age='Child'")
    double findErythrocytes();
    @Query(value = "SELECT AVG(e.leukocytes) FROM Patient e WHERE e.sex='Man' and e.age='Child'")
    double findLeukocytes();
}
