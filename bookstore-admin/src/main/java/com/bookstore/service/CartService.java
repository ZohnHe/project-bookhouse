package com.bookstore.service;

import com.bookstore.domain.CartBookEntity;
import com.bookstore.domain.CartEntity;
import org.springframework.stereotype.Service;

@Service
public interface CartService {

    void getCart(String username);

    String addBooks(CartEntity cart, CartBookEntity book);

    public String mult(String price, String num);

}
