package com.springboot.craftsman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.springboot.craftsman.*","com.springboot.craftsman.dao.mapper"})
public class SpringbootCraftsmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCraftsmanApplication.class, args);
    }

}
