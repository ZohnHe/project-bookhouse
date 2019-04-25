package com.bookstore.service.impl;

import com.bookstore.dao.mapping.ext.BookMapperExt;
import com.bookstore.domain.CartBookEntity;
import com.bookstore.domain.CartEntity;
import com.bookstore.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class CartServiceImpl implements CartService {

    @Resource
    BookMapperExt bookMapperExt;

    @Override
    public void getCart(String username) {

    }

    @Override
    public String addBooks(CartEntity cart, CartBookEntity book) {
        if (cart != null) {
            for (CartBookEntity cartBook : cart.getBooks()) {
                if (book.getName().equals(cartBook.getName())) {
                    //购物车中已存在同一本书。更新数量和价钱
                    cartBook.setNum(cartBook.getNum() + book.getNum());
                    cartBook.setAll(mult(cartBook.getPrice(), cartBook.getNum().toString()));
                    //购物车总价就写另一个方法计算
                    return "ok";
                }
            }
            //购物车中还没这本书,添加书
            cart.getBooks().add(book);
            return "ok";
        }
        //还没有购物车
        return "no";
    }

    /**
     * 计算总价
     */
    public String mult(String price, String num) {
        BigDecimal big1 = new BigDecimal(price);
        BigDecimal big2 = new BigDecimal(num);
        return big1.multiply(big2).toString();
    }

}
