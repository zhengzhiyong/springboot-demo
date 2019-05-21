package com.springboot.craftsman.dao.mapper;

import com.github.pagehelper.Page;
import com.springboot.craftsman.base.BootyBookPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 * https://blog.csdn.net/kingice1014/article/details/70263148
 * Mybatis mapper 注解详细使用方式
 *
 * Created by zheng on 2018/6/15.
 * 基于注释的写法，另外还有一种基于xml配置的方式
 */
@Mapper
public interface BookMapper {
    /**
     * 没有使用@Results和@Result前，teacherNumber和studentNumber获取的值均为0
     *
     * 查询学校集合
     * @return
     */
    @Select("SELECT ID,NAME,AUTHOR,BOOK_NO,IS_DAMAGE,IS_LEND,INTRODUCTION FROM BOOTY_BOOK")
    @Results({
            @Result(id =true,column = "ID",property = "id"),
            @Result(column = "NAME",property = "name"),
            @Result(column = "AUTHOR",property = "author"),
            @Result(column = "BOOK_NO",property = "bookNo"),
            @Result(column = "IS_DAMAGE",property = "isDamage"),
            @Result(column = "IS_LEND",property = "isLend"),
            @Result(column = "INTRODUCTION",property = "introduction")
    })
    Page<BootyBookPO> getAllBookList();

    /**
     * 根据ID查询学校
     * @param id
     * @return
     */
    @Select("SELECT ID,NAME,AUTHOR,BOOK_NO,IS_DAMAGE,IS_LEND,INTRODUCTION FROM BOOTY_BOOK WHERE ID=#{id}")
    @ResultType(BootyBookPO.class)
    @Results({
            @Result(id =true,column = "ID",property = "id"),
            @Result(column = "NAME",property = "name"),
            @Result(column = "AUTHOR",property = "author"),
            @Result(column = "BOOK_NO",property = "bookNo"),
            @Result(column = "IS_DAMAGE",property = "isDamage"),
            @Result(column = "IS_LEND",property = "isLend"),
            @Result(column = "INTRODUCTION",property = "introduction")
    })
    BootyBookPO getBookById(@Param("id") Long id);

    @Insert("insert into BOOTY_BOOK values(#{id},#{name},#{author},#{bookNo},#{isDamage},#{isLend},#{introduction})")
    int insertBook(@Param("id") Long id, @Param("name") String name, @Param("author") String author, @Param("bookNo") String bookNo, @Param("isDamage") int isDamage, @Param("isLend") int isLend, @Param("introduction") String introduction);


//    @Insert("insert into BOOTY_BOOK values(#{book.id},#{book.name},#{book.author},#{book.bookNo},#{book.isDamage},#{book.isLend},#{book.introduction})")
//    int insertBook2(@Param("book") BootyBookPO book);

    //主键自增法;将数据库中di设为自增类型即可
    @Insert("insert into BOOTY_BOOK  (name,author,book_no,is_damage,is_lend,introduction) values(#{book.name},#{book.author},#{book.bookNo},#{book.isDamage},#{book.isLend},#{book.introduction})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertBook3(@Param("book") BootyBookPO book);

    //使用selectkey的查询
    @Insert("insert into BOOTY_BOOK (id,name,author,book_no,is_damage,is_lend,introduction) values(#{id},#{book.name},#{book.author},#{book.bookNo},#{book.isDamage},#{book.isLend},#{book.introduction})")
    @SelectKey(statement = "SELECT UNIX_TIMESTAMP(NOW()) as id", keyColumn = "id", keyProperty = "id", resultType = Long.class, before = true)
    int insertBook2(@Param("book") BootyBookPO book);


    @Delete("DELETE FROM BOOTY_BOOK WHERE ID = #{id} ")
    int deleteBookById(@Param("id") Long id);

    @Update("UPDATE BOOTY_BOOK set name = #{book.name},author = #{book.author},book_no = #{book.bookNo},is_damage = #{book.isDamage},is_lend = #{book.isLend},introduction = #{book.introduction} WHERE ID = #{book.id}  ")
    void updateBook(@Param("book") BootyBookPO book);
}
