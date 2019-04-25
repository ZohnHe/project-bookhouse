package com.bookstore.controller;


import com.bookstore.common.BaseResponse;
import com.bookstore.common.constant.ResponseCode;
import com.bookstore.dao.pojo.Book;
import com.bookstore.domain.BooksDeleteEntity;
import com.bookstore.domain.BooksModifyEntity;
import com.bookstore.domain.BooksQueryEntity;
import com.bookstore.domain.vo.BookVo;
import com.bookstore.response.BooksAddResp;
import com.bookstore.response.BooksDeleteResp;
import com.bookstore.response.BooksListResp;
import com.bookstore.response.BooksModifyResp;
import com.bookstore.service.BooksService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@Api(tags = "图书管理模块")  //swagger分类标题注解
@RequestMapping(value = "/books")
public class BookController {

    @Resource
    BooksService booksService;

    @ApiOperation(value = "获取图书列表数据")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<BooksListResp<Book>> getBooksList(HttpServletRequest request, @RequestBody BooksQueryEntity booksQueryEntity) {
        PageInfo<Book> list = booksService.getBooksList(booksQueryEntity);

        /* 属性拷贝 */
        List<BookVo> data = new ArrayList<>();
        if (list.getList() != null) {
            for (Book book : list.getList()) {
                BookVo bean = new BookVo();
                try {
                    BeanUtils.copyProperties(book, bean);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                data.add(bean);
            }
        }

        //从页面工具类中赋值到书本数据响应类（只包含图书信息，不包含分页信息）
        BooksListResp<Book> responseEntity = new BooksListResp(data);

        //前端传来的分页信息赋值给响应实体
        responseEntity.setPageNum(booksQueryEntity.getPageNum());
        responseEntity.setPageSize(booksQueryEntity.getPageSize());
        responseEntity.setTotalRecord(list.getTotal());  //返回long int有长度限制 int的取值范围为: -2^31——2^31-1,即-2147483648——2147483647
        long totalPage = (responseEntity.getTotalRecord() + booksQueryEntity.getPageSize() - 1) / booksQueryEntity.getPageSize(); //(总记录数+分页数-1)/分页数
        responseEntity.setTotalPage(totalPage);

        return new BaseResponse(responseEntity);

    }


    @ApiOperation(value = "删除指定图书")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@Requestody解包，自定义协议、二进制字符串
    public BaseResponse<BooksDeleteResp> booksDelete(HttpServletRequest request, @Valid @RequestBody BooksDeleteEntity booksDeleteEntity, BindingResult errors) {
        BooksDeleteResp booksDeleteResp = new BooksDeleteResp();

        //  后台参数验证
        if (errors.hasErrors()) {
            List<ObjectError> errorList = errors.getAllErrors();
            StringBuilder sb = new StringBuilder();
            //String desc = "";
            for (ObjectError error : errorList) {
                FieldError fieldError = (FieldError) error;

                sb.append(fieldError.getDefaultMessage() + "|");
            }
            booksDeleteResp.setResult(0);

            BaseResponse baseResponse = new BaseResponse(booksDeleteResp);
            baseResponse.setCode(ResponseCode.FAIL.getCode());
            baseResponse.setMsg("参数输入错误");

            return baseResponse;
        }

        booksDeleteResp.setResult(booksService.booksDelete(booksDeleteEntity.getBooksIds()));

        return new BaseResponse(booksDeleteResp);
    }


    @ApiOperation(value = "添加图书")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<BooksAddResp> booksAdd(HttpServletRequest request, @RequestBody Book book) {

        BooksAddResp booksAddResp = new BooksAddResp();

        booksAddResp.setResult(booksService.booksAdd(book));

        return new BaseResponse(booksAddResp);
    }

    @ApiOperation(value = "修改图书信息")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @ResponseBody
    //ResponseBody封包,@RequestBody解包，自定义协议、二进制字符串
    public BaseResponse<BooksModifyResp> goodsModify(HttpServletRequest request, @Valid @RequestBody BooksModifyEntity booksModifyEntity, BindingResult errors) {

        BooksModifyResp booksModifyResp = new BooksModifyResp();

        //请求参数异常处理，加错误提示
        if (errors.hasErrors()) {
            List<ObjectError> errorList = errors.getAllErrors();
            StringBuilder sb = new StringBuilder();
            //String desc = "";
            for (ObjectError error : errorList) {
                FieldError fieldError = (FieldError) error;
                //desc = fieldError.getDefaultMessage();
                sb.append(fieldError.getDefaultMessage() + "|");
            }
            booksModifyResp.setResult(0);

            BaseResponse baseResponse = new BaseResponse(booksModifyResp);
            baseResponse.setCode(ResponseCode.FAIL.getCode());
            baseResponse.setMsg("参数输入错误");

            return baseResponse;
        }
        booksModifyResp.setResult(booksService.gooksModify(booksModifyEntity));

        return new BaseResponse(booksModifyResp);
    }

}
