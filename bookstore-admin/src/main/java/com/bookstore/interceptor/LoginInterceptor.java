package com.bookstore.interceptor;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 *
 *  登录拦截器
 *  检查是否有权限访问我们的index页面
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
    //调用接口前执行
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        System.out.println("日志记录开始-- 请求URL：" + httpServletRequest.getRequestURI());
        String headxxx = getHeader(httpServletRequest,"xxx");
        //httpServletRequest.getInputStream()  //只能读取一次
        // 判断用户是否登录
        if(StringUtils.isEmpty(headxxx)) {
            // BaseResponse response = new BaseResponse("201", "用户登录超时!");
            // String jsonStr = JSON.toJSONString(response);   //封包
            //String jsonStr = "{\"code\":\"201\",msg:\"用户登陆超时!\"}";   //封包
            // httpServletResponse.setContentType("application/json; charset=utf-8");
            // httpServletResponse.getWriter().write(jsonStr);
            return false;
        }
        // 放行
        return true;
    }
    public String getHeader(HttpServletRequest request, String key){
        StringBuilder str = new StringBuilder();
        Enumeration<String> e = request.getHeaderNames();
        while (e.hasMoreElements()){
            //String key = e.nextElement();
            //str.append(key).append(":").append(request.getHeader(key)).append("||");
            if(key.equals(e.nextElement())){
                str.append(request.getHeader(key));
            }
        }
        return str.toString();
    }
    //调用接口后执行
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("日志记录完成-- 请求URL：" + httpServletRequest.getRequestURI());
        // 如果请求来自登录页
/*        if (modelAndView.getViewName().endsWith("/getuserinfo")) {
            // 则直接重定向到首页不再显示登录页
            //httpServletResponse.sendRedirect("/index");
            ResponseEntity responseEntity = new ResponseEntity();
            responseEntity.setSuccess("1");

            String jsonStr = JSON.toJSONString(responseEntity);   //封包
            httpServletResponse.getWriter().write(jsonStr);
        }*/
    }
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}


