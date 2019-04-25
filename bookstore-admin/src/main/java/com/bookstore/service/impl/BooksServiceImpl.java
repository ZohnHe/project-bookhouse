package com.bookstore.service.impl;


import com.bookstore.dao.mapping.BookMapper;
import com.bookstore.dao.pojo.Book;
import com.bookstore.domain.BooksModifyEntity;
import com.bookstore.domain.BooksQueryEntity;
import com.bookstore.service.BooksService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    @Resource
    BookMapper bookMapper;


    @Override
//    获取图书列表
    public PageInfo<Book> getBooksList(BooksQueryEntity booksQueryEntity ) {
        //PageHelper.startPage(1,10);
        //配置显示第几页，显示几条数据
        PageHelper.startPage(booksQueryEntity.getPageNum(),booksQueryEntity.getPageSize());

        List<Book> books = new ArrayList<Book>();
        String bname = booksQueryEntity.getSearch();
        if (bname==null) {
            books = bookMapper.selectAll();
        }else{
            Example example = new Example(Book.class);
            // where 条件
            Example.Criteria criteria = example.createCriteria();

            criteria.andLike("bname", "%" + bname + "%");

            books = bookMapper.selectByExample(example);
        }

        //将搜索到的数据加载进页面显示类中
        return new PageInfo<Book>(books);
    }


    //批量删除图书
    @Override
    public int booksDelete(String[] booksIds) {
        Example example =new Example(Book.class);
        List<Object> list = new ArrayList<Object>();
        for (String booksId : booksIds) {
            list.add(booksId);
        }
        example.createCriteria().andIn("bid",list);
        return bookMapper.deleteByExample(example);
    }


//    图书添加
    @Override
    public int booksAdd(Book book) {
        return bookMapper.insert(book);
    }

//    图书修改
    @Override
    public int gooksModify(BooksModifyEntity booksModifyEntity) {
        Example example = new Example(Book.class);
        example.createCriteria().andEqualTo("bid",booksModifyEntity.getBid());
        List<Book> list = bookMapper.selectByExample(example);
        if( list != null && list.size() > 0){
            Book book = list.get(0);
            BeanUtils.copyProperties(booksModifyEntity,book);
            return  bookMapper.updateByExample(book,example);
        }
        return 0;
    }
}
