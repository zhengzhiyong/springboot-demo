package com.springboot.craftsman.base;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BootySchoolPO {
    private Long id;

    private String name;

    private int star;

    private String address;

    private int teacherNumber;

    private int studentNumber;

    private String introduction;
}
