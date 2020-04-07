package com.example.VWP_Covid_19_nie_wiesz_zapytaj.controllers;



import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//
//@NoArgsConstructor
@AllArgsConstructor
@Controller
public class HomeController {


    @GetMapping("/")
    public String homePage(
            Model model) {




        return "index";
    }


}