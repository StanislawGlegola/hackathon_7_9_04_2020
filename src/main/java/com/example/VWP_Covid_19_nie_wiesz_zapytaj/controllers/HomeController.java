package com.example.VWP_Covid_19_nie_wiesz_zapytaj.controllers;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//
//@NoArgsConstructor
@AllArgsConstructor
@Controller
public class HomeController {


    @GetMapping("/")
    public String homePage(Model model) {

        return "index";
    }

    @GetMapping("/survey")
    public String survey(Model model) {


        return "surveys package/survey";
    }
    @GetMapping("/applications-and-needs")
    public String applications_and_needs(Model model) {


        return "applications-and-needs package/applications-and-needs";
    }




}