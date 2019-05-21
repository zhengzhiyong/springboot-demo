package com.springboot.craftsman.service.impl;

import com.springboot.craftsman.base.BootySchoolPO;
import com.springboot.craftsman.dao.mapper.SchoolMapper;
import com.springboot.craftsman.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public List<BootySchoolPO> getAllSchoolList() {
        return schoolMapper.getAllSchoolList();
    }

    @Override
    public BootySchoolPO getBootySchoolById(Long id) {
        return schoolMapper.getBootySchoolById(id);
    }

    @Override
    public int insertBootySchool(Long id,String name,int star,String address,int teacherNumber,int studentNumber, String introduction){
        return schoolMapper.insertBootySchool(id,name,star,address,teacherNumber,studentNumber, introduction);
    }

    @Override
    public int deleteBootySchoolById(Long id) {
        return schoolMapper.deleteBootySchoolById(id);
    }
}
