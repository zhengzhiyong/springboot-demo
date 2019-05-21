package com.springboot.craftsman.controller.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @RequestMapping(value = "/user/sayHello/{name}",method = RequestMethod.GET)
    public String sayHello(@PathVariable("name") String name){
        return "Hello :" + name +" !";
    }

}
