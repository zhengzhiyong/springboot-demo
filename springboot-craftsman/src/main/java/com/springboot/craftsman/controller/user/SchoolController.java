package com.springboot.craftsman.controller.user;

import com.springboot.craftsman.base.BootySchoolPO;
import com.springboot.craftsman.common.page.RespModel;
import com.springboot.craftsman.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @ResponseBody
    @GetMapping(value = "getSchool/{id}" )
    public RespModel getSchool(@PathVariable("id") Long id){
        BootySchoolPO schoolPO = schoolService.getBootySchoolById(id);
        return new RespModel(RespModel.RespCode.SUCCESS.getCode(),schoolPO);
    }

}
