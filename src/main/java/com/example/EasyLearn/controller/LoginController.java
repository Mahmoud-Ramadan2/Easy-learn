package com.example.EasyLearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showloginpage")
    public String showLoginPage (){
        return "login-page";
    }

//    @GetMapping("/showregisterpage")
//    public String showRegisterPage (Model model){
//        model.addAttribute()
//        return "register-page";
//    }

    @GetMapping("/accessdenied")
    public String showAccessDenied (){
        return "error/access-denied";
    }

}
