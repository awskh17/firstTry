package com.example.demo.controllers;


import com.example.demo.repositories.patientRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class patientController {

    private final patientRepo patientRepo;

    public patientController(com.example.demo.repositories.patientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    @RequestMapping("/patients")
    public String patients(Model model) {
        model.addAttribute("patients", patientRepo.findAll());
        return "patients/list";
    }

}
