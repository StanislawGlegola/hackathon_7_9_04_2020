package com.example.VWP_Covid_19_nie_wiesz_zapytaj.controllers;

import com.example.VWP_Covid_19_nie_wiesz_zapytaj.security.UserApp;
import com.example.VWP_Covid_19_nie_wiesz_zapytaj.security.UserAppRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@AllArgsConstructor
@Controller
public class MenuController {

    private UserAppRepository userAppRepository;

    @GetMapping("/survey")
    public String survey(Model model) {
        return "surveys package/survey";
    }
    @GetMapping("/applications-and-needs")
    public String applications_and_needs(Model model) {


//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal()!= "anonymousUser");
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserApp userApp = (UserApp) authentication.getPrincipal();
            UserApp currentUser = userAppRepository.findUserAppById(userApp.getId());
            model.addAttribute("user_email", currentUser.getEmail());
        }
        return "applications-and-needs package/applications-and-needs";
    }



}
