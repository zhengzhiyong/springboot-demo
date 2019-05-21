package com.springboot.craftsman.service;

import com.github.pagehelper.PageInfo;
import com.springboot.craftsman.base.BootyBookPO;
import com.springboot.craftsman.base.BootySchoolPO;

import java.util.List;

public interface BookService {
    List<BootyBookPO> getAllBookList();

    BootyBookPO getBookById(Long id);

    int insertBook(Long id,String name, String author,String bookNo, int isDamage, int isLend, String introduction);

    int insertBook(BootyBookPO bookPO);

    int deleteBookById(Long id);

    PageInfo<BootyBookPO> getBookList(int start, int pageSize);

    void updateBook(BootyBookPO book);
}
