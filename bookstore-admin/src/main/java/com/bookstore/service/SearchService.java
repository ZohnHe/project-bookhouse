package com.bookstore.service;

import com.bookstore.dao.pojo.Book;
import com.bookstore.domain.SearchEntity;
import com.github.pagehelper.PageInfo;


public interface SearchService {

    PageInfo<Book> searchByKeywords(SearchEntity searchEntity);
}
