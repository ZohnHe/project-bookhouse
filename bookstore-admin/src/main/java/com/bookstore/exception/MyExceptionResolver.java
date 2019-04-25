package com.bookstore.exception;

import com.alibaba.fastjson.JSONObject;
import com.bookstore.common.BaseResponse;
import com.bookstore.common.constant.ResponseCode;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 全局异常处理
public class MyExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            BaseResponse baseResponse = new BaseResponse(null);
            baseResponse.setCode(ResponseCode.FAIL.getCode());
            baseResponse.setMsg(ex.getMessage());
            response.getWriter().write(JSONObject.toJSONString(baseResponse));
        } catch (IOException e) {

        }
        return new ModelAndView();
    }

}

// public class MyExceptionResolver implements HandlerExceptionResolver {
//     public ModelAndView resolveException(HttpServletRequest request,
//                                          HttpServletResponse response, Object handler, Exception ex) {
//         try {
//             response.setContentType("application/json;charset=UTF-8");
//             response.setCharacterEncoding("UTF-8");
//             response.getWriter().write("{\"errMsg\":\"系统繁忙，请稍后再试！\"}");
//         } catch (IOException e) {
//
//         }
//         return new ModelAndView();
//     }
// }
