package com.service;

import com.model.Age;
import com.model.Norma;
import com.model.Patient;
import com.model.Sex;
import com.repository.NormaRepository;
import com.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    NormaRepository normaRepository;
    public void Create()
    {


        /*for (Sex sex : Sex.values())
        {
            for(Age age : Age.values())
            {
                List<Patient> patientList = patientRepository.findAllBySexAndAge(sex, age);
                Norma norma = normaRepository.findBySexAndAge(sex, age);
            }
        }*/
    }
    private Boolean Solving(int i, int i1, String st){
        if(0.85*i>i1){
            return true;
        }
        else if(i<0.85*i1){
            return false;
        }
        return null;
    }
    private Boolean Solving(double i, double i1, String st){
        if(0.85*i>i1){
            return true;
        }
        else if(i<0.85*i1){
            return false;
        }
        return null;
    }
}
