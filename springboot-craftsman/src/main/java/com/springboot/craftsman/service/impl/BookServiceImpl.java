package com.springboot.craftsman.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.craftsman.base.BootyBookPO;
import com.springboot.craftsman.dao.mapper.BookMapper;
import com.springboot.craftsman.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BootyBookPO> getAllBookList() {
        return bookMapper.getAllBookList();
    }

    @Override
    public BootyBookPO getBookById(Long id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public int insertBook(Long id, String name, String author, String bookNo, int isDamage, int isLend, String introduction) {
        return bookMapper.insertBook(id,name,author,bookNo,isDamage,isLend,introduction);
    }

    @Override
    public int insertBook(BootyBookPO bookPO) {
        return bookMapper.insertBook2(bookPO);
    }

    @Override
    public int deleteBookById(Long id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public PageInfo<BootyBookPO> getBookList(int start, int pageSize) {
        PageHelper.startPage((start/pageSize+1),pageSize);
        Page<BootyBookPO> books =  bookMapper.getAllBookList();
        return new PageInfo(books);
    }

    @Override
    public void updateBook(BootyBookPO book) {
        bookMapper.updateBook(book);
    }
}
