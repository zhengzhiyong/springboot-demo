package com.springboot.craftsman.controller.user;

import com.springboot.craftsman.base.CompanyPO;
import com.springboot.craftsman.common.page.RespModel;
import com.springboot.craftsman.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @ResponseBody
    @GetMapping(value = "getCompany/{id}" )
    public RespModel getCompany(@PathVariable("id") Long id){
        CompanyPO company = companyService.getCompanyById(id);
        return new RespModel(RespModel.RespCode.SUCCESS.getCode(),company);
    }

}
