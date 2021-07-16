package com.example.MediScreen.service;

import com.example.MediScreen.model.Patient;
import com.example.MediScreen.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient getPatientById(int id) {
        return patientRepository.getById(id);
    }

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
