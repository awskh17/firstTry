package com.example.demo.controllers;


import com.example.demo.repositories.doctorRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class doctorController  {

    private final doctorRepo doctorRepo;

    public doctorController(doctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @RequestMapping("/doctors")
    public String doctors(Model model) {

        model.addAttribute("doctors", doctorRepo.findAll());

        return "doctors/list.html";
    }

}
