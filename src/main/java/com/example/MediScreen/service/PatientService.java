package com.example.MediScreen.service;

import com.example.MediScreen.model.Patient;

import java.util.List;

public interface PatientService {

    public Patient getPatientById(int id);

    public void savePatient(Patient patient);

    public void updatePatient(Patient patient);

    public void deletePatient(int id);

    public List<Patient> getAllPatients();

}
