package com.service;

import com.model.Patient;
import com.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    public List<Patient> findAll()
    {
        return patientRepository.findAll();
    }
    public List<Patient> findAllBySex(String sex)
    {
        return patientRepository.findAllBySex(sex);
    }
    public List<Patient> findAllByAge(String age)
    {
        return patientRepository.findAllBySex(age);
    }
   /* public List<Patient> findAllByAgeAndSex(String age, String sex)
    {
        List<Patient> patients = patientRepository.findAllBySex(age);
        List<Patient> p = (List<Patient>) patients
                .stream()
                .filter(patient -> patient.getSex().equals(sex));
    }*/
}
