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

@Controller
@AllArgsConstructor
public class UserMenuController {

    private UserAppRepository userAppRepository;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/account-menu/account-index")
    public String accountIndex(Model model) {
        return "account-menu/account-index";
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/account-menu/account-questions")
    public String accountQuestions(Model model) {
        return "account-menu/account-questions";
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/account-menu/account-private-messages")
    public String accountPrivateMessages(Model model) {
        return "account-menu/account-private-messages";
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/account-menu/account-data")
    public String accountData(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserApp userApp = (UserApp) authentication.getPrincipal();
        UserApp currentUser = userAppRepository.findUserAppById(userApp.getId());

        model.addAttribute("user", currentUser);
        return "account-menu/account-data";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/account-menu/admin-panel")
    public String adminPanel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserApp userApp = (UserApp) authentication.getPrincipal();
        UserApp currentUser = userAppRepository.findUserAppById(userApp.getId());

        model.addAttribute("user", currentUser);
        return "account-menu/admin-panel";
    }





}
