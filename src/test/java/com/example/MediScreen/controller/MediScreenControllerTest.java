package com.example.MediScreen.controller;

import com.example.MediScreen.dto.PatientDto;
import com.example.MediScreen.model.Patient;
import com.example.MediScreen.service.PatientService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringRunner.class)
@SpringBootTest
class MediScreenControllerTest {

    @Mock
    PatientService patientService;

    @InjectMocks
    MediScreenController mediScreenController;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    @Test
    void adminHome() {
        ModelAndView modelAndView = mediScreenController.adminHome(model);
        Assert.assertEquals("redirect:patient/list", modelAndView.getViewName());
    }

    @Test
    void home() {
        ModelAndView modelAndView = mediScreenController.home(model);
        Assert.assertEquals("patient/list", modelAndView.getViewName());
    }

    @Test
    void addPatient() {
        Patient patient = new Patient();
        patient.setId(21);
        patient.setPatientName("Test1");
        patient.setFamilyName("TestFamily1");
        patient.setSex("M");
        patient.setDateOfBirth("1957-8-8");
        patient.setHomeAddress("Test address");
        patient.setPhoneNo("1234-444-444");
        ModelAndView modelAndView = mediScreenController.addPatient(patient);
        Assert.assertEquals("patient/add", modelAndView.getViewName());
    }

    @Test
    void validate() {
        Patient patient = new Patient();
        patient.setId(21);
        patient.setPatientName("Test1");
        patient.setFamilyName("TestFamily1");
        patient.setSex("M");
        patient.setDateOfBirth("1957-8-8");
        patient.setHomeAddress("Test address");
        patient.setPhoneNo("1234-444-444");
        ModelAndView modelAndView = mediScreenController.validate(patient, bindingResult, model);
        Assert.assertEquals("redirect:/patient/list", modelAndView.getViewName());
    }

    @Test
    void showUpdateForm() {
        Patient patient = new Patient();
        patient.setId(21);
        patient.setPatientName("Test1");
        patient.setFamilyName("TestFamily1");
        patient.setSex("M");
        patient.setDateOfBirth("1957-8-8");
        patient.setHomeAddress("Test address");
        patient.setPhoneNo("1234-444-444");
        Mockito.when(patientService.getPatientById(21)).thenReturn(patient);
        ModelAndView modelAndView = mediScreenController.showUpdateForm(21, model);
        Assert.assertEquals("patient/update", modelAndView.getViewName());
    }

    @Test
    void updatePatient() {
        Patient patient = new Patient();
        patient.setId(21);
        patient.setPatientName("Test1");
        patient.setFamilyName("TestFamily1");
        patient.setSex("M");
        patient.setDateOfBirth("1957-8-8");
        patient.setHomeAddress("Test address");
        patient.setPhoneNo("1234-444-444");
        ModelAndView modelAndView = mediScreenController.updatePatient(21, patient, bindingResult, model);
        Assert.assertEquals("redirect:/patient/list", modelAndView.getViewName());
    }

    @Test
    void deletePatient() {
        Patient patient = new Patient();
        patient.setId(21);
        patient.setPatientName("Test1");
        patient.setFamilyName("TestFamily1");
        patient.setSex("M");
        patient.setDateOfBirth("1957-8-8");
        patient.setHomeAddress("Test address");
        patient.setPhoneNo("1234-444-444");
        Mockito.when(patientService.getPatientById(21)).thenReturn(patient);
        ModelAndView modelAndView = mediScreenController.deletePatient(21, model);
        Assert.assertEquals("redirect:/patient/list", modelAndView.getViewName());
    }

    @Test
    void addPatientInfo() {
        String s = mediScreenController.addPatientInfo("Test1", "TestFamily1", "1957-8-8", "M",
                "Test address", "1234-444-444");
        Assert.assertEquals("data saved", s);
    }

    @Test
    void getPatientInfo() {
        Patient patient = new Patient();
        patient.setId(21);
        patient.setPatientName("Test1");
        patient.setFamilyName("TestFamily1");
        patient.setSex("M");
        patient.setDateOfBirth("1957-8-8");
        patient.setHomeAddress("Test adddress");
        patient.setPhoneNo("1234-444-444");
        Mockito.when(patientService.getPatientById(21)).thenReturn(patient);
        PatientDto patientDto = mediScreenController.getPatientInfo(21);
        Assert.assertEquals("Test1", patientDto.getPatientName());
    }

}