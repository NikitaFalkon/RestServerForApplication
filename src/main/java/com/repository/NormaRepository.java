package com.repository;

import com.model.Age;
import com.model.Norma;
import com.model.Patient;
import com.model.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NormaRepository extends JpaRepository<Norma, Long> {
    Norma findBySexAndAge(Sex sex, Age age);

    List<Norma> findAllByAge(Age age);
}
