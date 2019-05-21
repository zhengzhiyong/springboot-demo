package com.springboot.craftsman.dao.mapper;

import com.springboot.craftsman.base.CompanyPO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CompanyMapper {
    /**
     * 根据ID查询公司
     * @param id
     * @return
     */
    @Select("SELECT ID,COMPANY_NAME,SHORT_NAME,AREA_CODE,ADDRESS,STREET,DELETE_FLAG,CREATE_TIME,CREATE_ID,UPDATE_TIME,UPDATE_ID,LANGUAGE_CODE FROM JMZX_COMPANY WHERE ID=#{id}")
    @Results({
        @Result(id =true,column = "ID",property = "id"),
        @Result(column = "COMPANY_NAME",property = "companyName"),
        @Result(column = "SHORT_NAME",property = "shortName"),
        @Result(column = "AREA_CODE",property = "areaCode"),
        @Result(column = "ADDRESS",property = "address"),
        @Result(column = "STREET",property = "street"),
        @Result(column = "DELETE_FLAG",property = "deleteFlag"),
        @Result(column = "CREATE_TIME",property = "createTime"),
        @Result(column = "CREATE_ID",property = "createId"),
        @Result(column = "UPDATE_TIME",property = "updateTime"),
        @Result(column = "UPDATE_ID",property = "updateId"),
        @Result(column = "LANGUAGE_CODE",property = "languageCode")
    })
    @ResultType(CompanyPO.class)
    CompanyPO getCompanyPOById(@Param("id") Long id);
}




