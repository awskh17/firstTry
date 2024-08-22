package com.example.demo.controllers;


import com.example.demo.repositories.hospitalRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class hospitalController {

    hospitalRepo hospitalRepo;

    public hospitalController(com.example.demo.repositories.hospitalRepo hospitalRepo) {
        this.hospitalRepo = hospitalRepo;
    }

    @RequestMapping("/hospitals")
    public String hospitals(Model model) {
        model.addAttribute("hospitals", hospitalRepo.findAll());
        return "hospitals/list";
    }
}
