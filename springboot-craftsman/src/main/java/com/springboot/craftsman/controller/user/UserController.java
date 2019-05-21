package com.springboot.craftsman.controller.user;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
public class UserController {

    @RequestMapping(value = "/user/sayHello/{name}",method = RequestMethod.GET)
    public String sayHello(@PathVariable("name") String name){
        return "Hello :" + name +" !";
    }

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
