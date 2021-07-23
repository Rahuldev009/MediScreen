package com.example.MediScreen.controller;

import com.example.MediScreen.dto.PatientDto;
import com.example.MediScreen.model.Patient;
import com.example.MediScreen.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MediScreenController {

    private Logger logger = LoggerFactory.getLogger(MediScreenController.class);
    private PatientService patientService;

    @Autowired
    public MediScreenController(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * This is the home page - shows data of all patients
     * @param model
     * @return ModelAndView
     */
    @RequestMapping("/")
    public ModelAndView adminHome(Model model) {
        logger.info("home page after login");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/patient/list");
        return modelAndView;
    }

    /**
     * HTTP GET request shows list of all patients present in Database
     * @param model
     * @return ModelAndView
     */
    @RequestMapping("/patient/list")
    public ModelAndView home(Model model) {
        List<Patient> patientList = patientService.getAllPatients();
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("patientList", patientList);
        logger.info("all patients list"+ patientList.toString());
        modelAndView.setViewName("patient/list");
        return modelAndView;
    }

    /**
     * HTTP GET request loads form for new patient data entry
     * @param patient
     * @return ModelAndView
     */
    @GetMapping("/patient/add")
    public ModelAndView addPatient(Patient patient) {
        logger.info("patient to be added ");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patient", patient);
        modelAndView.setViewName("patient/add");
        return modelAndView;
    }

    /**
     * HTTP POST request validates the data and if correct create a new entry in DB
     * @param patient
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PostMapping("/patient/validate")
    public ModelAndView validate(@Valid Patient patient, BindingResult result, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        if (!result.hasErrors()) {
            logger.info("patient to be added "+ patient.toString());
            patientService.savePatient(patient);
            model.addAttribute("patientList", patientService.getAllPatients());
            modelAndView.setViewName("redirect:/patient/list");
            return modelAndView;
        }
        modelAndView.setViewName("patient/add");
        return modelAndView;
    }

    /**
     * HTTP GET request loads form for updating the Patient entry
     * @param id
     * @param model
     * @return ModelAndView
     */
    @GetMapping("/patient/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") Integer id, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Patient patient = patientService.getPatientById(id);
        logger.info("patient to be updated "+ patient.toString());
        model.addAttribute("patient", patient);
        modelAndView.setViewName("patient/update");
        return modelAndView;
    }

    /**
     * HTTP POST request validates the data and if correct, update the DB
     * @param id
     * @param patient
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PostMapping("/patient/update/{id}")
    public ModelAndView updateBid(@PathVariable("id") Integer id, @Valid Patient patient,
                                  BindingResult result, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("patient/update");
            return modelAndView;
        }
        patient.setId(id);
        logger.info("patient to be updated "+ patient.toString());
        patientService.updatePatient(patient);
        model.addAttribute("patientList", patientService.getAllPatients());
        modelAndView.setViewName("redirect:/patient/list");
        return modelAndView;
    }

    /**
     * HTTP GET request deletes the requested patient entry from DB
     * @param id
     * @param model
     * @return ModelAndView
     */
    @GetMapping("/patient/delete/{id}")
    public ModelAndView deletePatient(@PathVariable("id") Integer id, Model model) {
        logger.info("patient to be deleted "+ patientService.getPatientById(id).toString());
        ModelAndView modelAndView = new ModelAndView();
        patientService.deletePatient(id);
        model.addAttribute("patientList", patientService.getAllPatients());
        modelAndView.setViewName("redirect:/patient/list");
        return modelAndView;
    }

    /**
     * HTTP POST request to add patient data to DB
     * @param given
     * @param family
     * @param dob
     * @param sex
     * @param address
     * @param phone
     * @return String
     */
    @PostMapping("/patient/add")
    public String addPatientInfo(@RequestParam String given, @RequestParam String family,
                                 @RequestParam String dob, @RequestParam String sex,
                                 @RequestParam String address, @RequestParam String phone) {
        Patient patient = new Patient();
        patient.setPatientName(given);
        patient.setFamilyName(family);
        patient.setDateOfBirth(dob);
        patient.setSex(sex);
        patient.setHomeAddress(address);
        patient.setPhoneNo(phone);
        logger.info("patient to be added "+ patient.toString());
        patientService.savePatient(patient);
        return "data saved";
    }

    /**
     * HTTP POST request to return the request patient data on the basis of ID
     * @param id
     * @return PatientDto
     */
    @GetMapping("/getPatientInfo")
    public PatientDto getPatientInfo(@RequestParam int id) {
        Patient patient = patientService.getPatientById(id);
        PatientDto patientDto = new PatientDto();
        patientDto.setPatientName(patient.getPatientName());
        patientDto.setId(patient.getId());
        patientDto.setFamilyName(patient.getFamilyName());
        patientDto.setSex(patient.getSex());
        patientDto.setDateOfBirth(patient.getDateOfBirth());
        logger.info("patient info "+ patientDto.toString());
        return patientDto;
    }

}
