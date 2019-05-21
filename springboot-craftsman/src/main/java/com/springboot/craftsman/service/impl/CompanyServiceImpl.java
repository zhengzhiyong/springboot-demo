package com.springboot.craftsman.service.impl;

import com.springboot.craftsman.base.CompanyPO;
import com.springboot.craftsman.dao.mapper.CompanyMapper;
import com.springboot.craftsman.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CompanyServiceImpl implements CompanyService {

    private Logger logger = Logger.getLogger(CompanyServiceImpl.class.getName());

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public CompanyPO getCompanyById(Long id) {
        CompanyPO company = companyMapper.getCompanyPOById(id);
        logger.info(company.toString());
        return company;
    }
}
