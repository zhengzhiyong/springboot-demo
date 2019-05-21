package com.springboot.craftsman.base;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class CompanyPO implements Serializable {

        private Long id;

        /** 公司名称 */
        private String companyName;

        /** 公司简称 */
        private String shortName;

        /** 地址编码 */
        private Long areaCode;

        /** 地址 */
        private String address;

        /** 街道地址 */
        private String street;

        /** 删除标记（0=未删除，1=已删除） */
        private Short deleteFlag;

        /** 创建时间 */
        private Date createTime;

        /** 创建人 */
        private Long createId;

        /** 最后修改时间 */
        private Date updateTime;

        /** 最后修改人 */
        private Long updateId;

        /** 语言 */
        private String languageCode;
}