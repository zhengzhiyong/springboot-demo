package com.springboot.craftsman.controller.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
public class LoginController {
    @RequestMapping(value = "/")
    public ModelAndView index() {
        return new ModelAndView("login");
    }


    @RequestMapping(value = "/welcome")
    public ModelAndView welcome() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }
}
