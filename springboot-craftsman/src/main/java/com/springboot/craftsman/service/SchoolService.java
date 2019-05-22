package com.springboot.craftsman.service;

import com.springboot.craftsman.base.BootySchoolPO;

import java.util.List;

public interface SchoolService {
    List<BootySchoolPO> getAllSchoolList();

    BootySchoolPO getBootySchoolById(Long id);

    int insertBootySchool(Long id,String name,int star,String address,int teacherNumber,int studentNumber, String introduction);

    int deleteBootySchoolById(Long id);
}
