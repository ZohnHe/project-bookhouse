package com.bookstore.dao.mapping.ext;

import com.bookstore.dao.pojo.Book;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookMapperExt extends Mapper<Book> {

    List<Book> getBookStockById(@Param("bid") Integer bid);
    List<Book> getBookInfoById(@Param("bid") Integer bid);

}