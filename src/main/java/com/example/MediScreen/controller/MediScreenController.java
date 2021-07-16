package com.example.MediScreen.controller;

import com.example.MediScreen.model.Patient;
import com.example.MediScreen.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MediScreenController {

    @Autowired
    PatientService patientService;

    @RequestMapping("/test")
    public String testMethod() {
        return "hello world";
    }

    @RequestMapping("/")
    public String adminHome(Model model) {
        // logger.info("home page after login");
        return "redirect:/patient/list";
    }

    @RequestMapping("/patient/list")
    public String home(Model model) {
        List<Patient> patientList = patientService.getAllPatients();
        model.addAttribute("patientList", patientList);
        // logger.info("all patients list"+ patients.toString());
        return "patient/list";
    }

    @GetMapping("/patient/add")
    public ModelAndView addPatient(Patient patient) {
        // logger.info("patient to be added ");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patient",patient);
        modelAndView.setViewName("patient/add");
        return modelAndView;
    }


    @PostMapping("/patient/validate")
    public ModelAndView validate(@Valid Patient patient, BindingResult result, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        if (!result.hasErrors()) {
            //  logger.info("patient to be added "+ patient.toString());
            patientService.savePatient(patient);
            model.addAttribute("patientList", patientService.getAllPatients());
            modelAndView.setViewName("redirect:/patient/list");
            return modelAndView;
        }
        modelAndView.setViewName("patient/add");
        return modelAndView;
    }

    @GetMapping("/patient/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Patient patient = patientService.getPatientById(id);
        //logger.info("patient to be updated "+ patient.toString());
        model.addAttribute("patient", patient);
        return "patient/update";
    }

    @PostMapping("/patient/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid Patient patient,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "patient/update";
        }
        patient.setId(id);
        // logger.info("patient to be updated "+ patient.toString());
        patientService.updatePatient(patient);
        model.addAttribute("patientList", patientService.getAllPatients());
        return "redirect:/patient/list";
    }

    @GetMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable("id") Integer id, Model model) {
        // logger.info("patient to be deleted "+ patientService.getpatientById(id).toString());
        patientService.deletePatient(id);
        model.addAttribute("patientList", patientService.getAllPatients());
        return "redirect:/patient/list";
    }

//    @PostMapping("/patient/add")
//
//    public String addPatient(@RequestParam String given, @RequestParam String family,
//                             @RequestParam String dob, @RequestParam String sex,
//                             @RequestParam String address, @RequestParam String phone) {
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate = LocalDate.parse(dob, format);
//        Patient patient = new Patient();
//        patient.setPatientName(given);
//        patient.setFamilyName(family);
//        patient.setDateOfBirth(localDate);
//        patient.setSex(sex);
//        patient.setHomeAddress(address);
//        patient.setPhoneNo(phone);
//
//        patientService.savePatient(patient);
//        return "saved data";
//
//    }


}
