package com.bookstore.controller;

import com.bookstore.common.BaseResponse;
import com.bookstore.dao.pojo.Book;
import com.bookstore.domain.SearchEntity;
import com.bookstore.domain.vo.SearchVo;
import com.bookstore.response.SearchResp;
import com.bookstore.service.SearchService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;

/**
 * 前端搜索
 */
@Api(tags = "前端搜索模块")
@Controller
public class SearchController {

    @Resource
    SearchService searchService;

    @ApiOperation(value = "前端搜索")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<SearchResp<SearchVo>> search(HttpServletRequest httpServletRequest, @Valid @RequestBody SearchEntity searchEntity){
        PageInfo<Book> list = searchService.searchByKeywords(searchEntity);

        ArrayList<SearchVo> data = new ArrayList<>();

        if (list != null) {
            for (Book book : list.getList()) {
                SearchVo searchVo = new SearchVo();
                try {
                    BeanUtils.copyProperties(book, searchVo);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                data.add(searchVo);
            }
        }

        SearchResp<SearchVo> searchResp = new SearchResp<>();
        searchResp.setData(data.get(0));
        // searchResp.setResult();
        return new BaseResponse(searchResp);
    }
}
