package com.example.MediScreen.service;

import com.example.MediScreen.model.Patient;
import com.example.MediScreen.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Patient data on the basis of ID
     * @param id
     * @return patient
     */
    @Override
    public Patient getPatientById(int id) {
        return patientRepository.getById(id);
    }

    /**
     * Create a new patient entry in DB
     * @param patient
     */
    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    /**
     * Update patient entry
     * @param patient
     */
    @Override
    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }

    /**
     * Delete patient entry on the basis of ID
     * @param id
     */
    @Override
    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }

    /**
     * List of all patients
     * @return List
     */
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

}
