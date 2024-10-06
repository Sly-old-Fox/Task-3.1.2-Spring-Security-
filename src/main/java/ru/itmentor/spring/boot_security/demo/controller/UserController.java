package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmentor.spring.boot_security.demo.security.UserDetailsWrapper;


@Controller
@RequestMapping("/user")
public class UserController {

        @GetMapping
    public String getUserInfo(Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        UserDetailsWrapper userDetailsWrapper=    (UserDetailsWrapper)authentication.getPrincipal();
        model.addAttribute("userInfo",((userDetailsWrapper.getUser())));
        return "users/user";
    }
}
