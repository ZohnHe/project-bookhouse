package com.bookstore.controller;

import com.bookstore.common.BaseResponse;
import com.bookstore.common.constant.CarRsp;
import com.bookstore.dao.mapping.ext.BookMapperExt;
import com.bookstore.dao.pojo.Book;
import com.bookstore.domain.CartBookEntity;
import com.bookstore.domain.CartEntity;
import com.bookstore.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@Api(tags="购物车模块")
@RequestMapping(value = "/user")
public class CartController {

    @Resource
    CartService cartService;
    @Resource
    BookMapperExt bookMapperExt;


    @RequestMapping(value = "/toProduct", method = RequestMethod.GET)
    public String toProduct() {
        return "ui/product";
    }

    /**
     * 添加购物车
     */
    @ApiOperation(value = "加入购物车")
    @ResponseBody
    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    public BaseResponse<CarRsp> AddBooks( @RequestBody CartBookEntity book, HttpServletRequest request){
        String username = book.getUsername();

        CartEntity cart = (CartEntity) request.getSession().getAttribute(username+"Cart");

        String state = cartService.addBooks(cart, book);
        if (!"ok".equals(state)) {
            //没有购物车，新建一个
            List<CartBookEntity> books = new ArrayList<>();
            books.add(book);
            CartEntity newCart = new CartEntity(username, books, book.getAll());
            request.getSession().setAttribute(username+"Cart",newCart);
        }
        CarRsp carRsp = new CarRsp();
        return new BaseResponse<CarRsp>(carRsp);
    }

    /**
     * 获取session中的购物车信息
     */
    @ResponseBody
    @RequestMapping(value = "/getCart", method = RequestMethod.GET)
    public BaseResponse<CartEntity> GetCart(String username, HttpServletRequest request) {
//        username = "axx";
         CartEntity  cartEntity =  (CartEntity) request.getSession().getAttribute(username + "Cart");
        return new BaseResponse<CartEntity>(cartEntity);
    }

    /**
     * 书籍详情页获取书籍信息
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getBookInfo", method = RequestMethod.GET)
    public Book getBookInfo(String bid, HttpServletRequest request) {
        // String bid = request.getParameter("bid");
        List<Book> list = bookMapperExt.getBookInfoById(Integer.parseInt(bid));
        return list.get(0);
    }
}
