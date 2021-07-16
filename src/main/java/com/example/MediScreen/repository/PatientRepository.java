package com.example.MediScreen.repository;

import com.example.MediScreen.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <Patient,Integer> {
}
