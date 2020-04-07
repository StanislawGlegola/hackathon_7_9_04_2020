package com.example.VWP_Covid_19_nie_wiesz_zapytaj.security;


import com.example.VWP_Covid_19_nie_wiesz_zapytaj.validators.UserRegisterValidator;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;


//CONTROLLER

@Controller
public class RegisterController {
    private CustomUserService customUserService;

    private MessageSource messageSource;

    public RegisterController(CustomUserService customUserService, MessageSource messageSource) {
        this.customUserService = customUserService;
        this.messageSource = messageSource;
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute LoginUser loginUser, BindingResult result, Model model, Locale locale) {
        UserApp userExist = customUserService.findUserByEmail(loginUser.getEmail());

        new UserRegisterValidator().validate(loginUser, result);
        new UserRegisterValidator().validateEmailExist(userExist, result);
        if (result.hasErrors()) {
            return "security/register";
        } else {
            customUserService.saveUserApp(loginUser);
            model.addAttribute("message", messageSource.getMessage("user.register.success", null, locale));
            model.addAttribute("loginUser", new LoginUser());
            return "security/login";
        }
    }
    @GetMapping("/register")
    public String loginPage(Model model) {
        LoginUser loginUser = new LoginUser();
        model.addAttribute("loginUser", loginUser);
        return "security/register";
    }
}
