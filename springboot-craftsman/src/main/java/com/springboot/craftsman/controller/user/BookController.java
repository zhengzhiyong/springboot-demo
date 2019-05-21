package com.springboot.craftsman.controller.user;

import com.github.pagehelper.PageInfo;
import com.springboot.craftsman.base.BootyBookPO;
import com.springboot.craftsman.common.page.PageRespModel;
import com.springboot.craftsman.common.page.RespModel;
import com.springboot.craftsman.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @ResponseBody
    @GetMapping(value = "getBook/{id}" )
    public RespModel getBook(@PathVariable("id") Long id){
        BootyBookPO book = bookService.getBookById(id);
        return new RespModel(RespModel.RespCode.SUCCESS.getCode(),book);
    }

    @RequestMapping(value = "getBookList")
    @ResponseBody
    public PageRespModel getBookList(int startRow, int pageSize){
        PageInfo<BootyBookPO> books = bookService.getBookList(startRow,pageSize);
        PageRespModel model = new PageRespModel();
        model.setRows(books.getList());
        model.setTotal((int)books.getTotal());
        return model;
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public RespModel update(BootyBookPO bookPO){
        RespModel respModel = new RespModel();
        bookService.updateBook(bookPO);
        return respModel;
    }


    @RequestMapping(value = "add")
    @ResponseBody
    public RespModel add(BootyBookPO bookPO){
        RespModel respModel = new RespModel();
        bookService.insertBook(bookPO);
        return respModel;
    }

    @RequestMapping(value = "delete/{id}")
    @ResponseBody
    public RespModel delete(@PathVariable(value = "id") Long id){
        RespModel respModel = new RespModel();
        bookService.deleteBookById(id);
        return respModel;
    }

}
