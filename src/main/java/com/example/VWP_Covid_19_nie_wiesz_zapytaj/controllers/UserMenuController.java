package com.example.VWP_Covid_19_nie_wiesz_zapytaj.controllers;



import com.example.VWP_Covid_19_nie_wiesz_zapytaj.mappers.MessagesMapper;
import com.example.VWP_Covid_19_nie_wiesz_zapytaj.models.MessagesDto;
import com.example.VWP_Covid_19_nie_wiesz_zapytaj.security.UserApp;
import com.example.VWP_Covid_19_nie_wiesz_zapytaj.security.UserAppRepository;
import com.example.VWP_Covid_19_nie_wiesz_zapytaj.services.MessagesService;
import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class UserMenuController {



    private MessagesMapper messagesMapper;
    private MessagesService messagesService;

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
    @GetMapping("/account-menu/account-sended-messages")
    public String accountSendedMessages(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserApp userApp = (UserApp) authentication.getPrincipal();
        Long id = Long.valueOf(userApp.getId());


        model.addAttribute("sended_messages", messagesService.getMessages(id));



        return "account-menu/account-sended-messages";

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


    @PostMapping("/sendMessage")
    public String addMessage(Model model,
                             @Nullable @RequestParam(value = "name") String name,
                             @RequestParam(value = "email_sender") String email_sender,
                             @RequestParam(value = "id_recipient") Long id_recipient,
                             @RequestParam(value = "text_msg") String text_msg) {
        System.out.println("trololo");
        System.out.println(name);

        Long id_sender = null;

        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserApp userApp = (UserApp) authentication.getPrincipal();
            id_sender =Long.valueOf(userApp.getId());
        }
        System.out.println(id_sender);

        System.out.println("sdsad   " + id_recipient);



        MessagesDto messagesDto = MessagesDto.builder()
                .id_sender(id_sender)
                .id_recipient(id_recipient)
                .email_sender(email_sender)
                .text_msg(text_msg)
                .build();

        messagesService.saveMessage(messagesMapper.reverseMap(messagesDto));
        return "redirect:/";
    }








}
