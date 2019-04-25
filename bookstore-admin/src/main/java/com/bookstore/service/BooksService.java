package com.bookstore.service;

import com.bookstore.dao.pojo.Book;
import com.bookstore.domain.BooksModifyEntity;
import com.bookstore.domain.BooksQueryEntity;
import com.github.pagehelper.PageInfo;

public interface BooksService {
    PageInfo<Book> getBooksList(BooksQueryEntity booksQueryEntity);
    int booksDelete(String[] booksIds);
    int booksAdd(Book book);
    int gooksModify(BooksModifyEntity booksModifyEntity);
}