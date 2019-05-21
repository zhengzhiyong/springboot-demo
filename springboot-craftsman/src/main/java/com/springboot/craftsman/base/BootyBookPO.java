package com.springboot.craftsman.base;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BootyBookPO {
    private Long id;

    private String name;

    private String author;

    private String bookNo;

    private int isDamage;

    private int isLend;

    private String introduction;
}
