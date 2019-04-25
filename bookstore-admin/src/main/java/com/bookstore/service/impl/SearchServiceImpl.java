package com.bookstore.service.impl;

import com.bookstore.dao.mapping.BookMapper;
import com.bookstore.dao.pojo.Book;
import com.bookstore.domain.SearchEntity;
import com.bookstore.service.SearchService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查询的实现类
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Resource
    BookMapper bookMapper;

    @Override
    public PageInfo<Book> searchByKeywords(SearchEntity searchEntity) {


        List<Book> books = null;
        String keywords = searchEntity.getKeywords();
        if (keywords != null) {
            Example example = new Example(Book.class);
            Example.Criteria criteria = example.createCriteria();

            // 书名和作者搜索
            criteria.andLike("bname","%" + keywords + "%");
            criteria.orLike("writer","%" + keywords + "%");
            books = bookMapper.selectByExample(example);

        }


        return new PageInfo<Book>(books);

    }
}
