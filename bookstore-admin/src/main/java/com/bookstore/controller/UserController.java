package com.bookstore.controller;

import com.bookstore.common.BaseResponse;
import com.bookstore.dao.pojo.User;
import com.bookstore.domain.LoginEntity;
import com.bookstore.domain.RegisterEntity;
import com.bookstore.domain.RegisterRemoteEntity;
import com.bookstore.response.LoginResp;
import com.bookstore.response.RRemoteResp;
import com.bookstore.response.RegisterResp;
import com.bookstore.service.UserService;
import com.bookstore.service.utils.RequestDeal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/19 8:10
 * @Version 1.0.0
 */
@Controller
@Api(tags = "普通用户模块")  //swagger分类标题注解
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    UserService userService;

    //    集中处理页面跳转
    @RequestMapping(value = "toIndex", method=RequestMethod.GET)
    public String toIndex() {
        return "ui/index";
    }

    @RequestMapping(value = "toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "ui/userLogin";
    }

    @RequestMapping(value = "toRegister", method = RequestMethod.GET)
    public String toRegister() {
        return "ui/userRegister";
    }

    @RequestMapping(value = "toSort", method = RequestMethod.GET)
    public String toSort() {
        return "ui/categories";
    }

    @RequestMapping(value = "toCart", method = RequestMethod.GET)
    public String toCart() {
        return "ui/cart";
    }


    @ApiOperation(value = "普通用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<LoginResp> login(HttpServletRequest request, @Valid @RequestBody LoginEntity loginEntity, BindingResult errors) {
        //服务端验证,通用参数异常处理,跳到了全局异常处理,code=500(貌似登陆不验证)
        RequestDeal.requestDeal(errors);

        LoginResp loginResp = new LoginResp();
        User user = userService.getUserInfo(loginEntity);
        if (user != null) {
            //登陆凭证
            request.getSession().setAttribute("user", user);
            loginResp.setSuccess("1");
            //缓存id
            loginResp.setSessionId(user.getUid() + "");
        } else {
            loginResp.setSuccess("0");
        }
        //主要前端对字段success进行判断
        return new BaseResponse(loginResp);
    }

    @ApiOperation(value = "登陆时获取盐值")
    @RequestMapping(value = "/salt", method = RequestMethod.GET)
    @ResponseBody
    public String getSalt(String emailphone) {
        return userService.getSaltByEmailPhone(emailphone);
    }


    @ApiOperation(value = "普通用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<RegisterResp> register(HttpServletRequest request, @Valid @RequestBody RegisterEntity registerEntity, BindingResult errors) {
        //服务端验证,通用参数异常处理,跳到了全局异常处理,code=500(貌似登陆不验证)
        RequestDeal.requestDeal(errors);
        RegisterResp registerResp = new RegisterResp();
        Integer result = userService.getRegister(registerEntity);
        if (result == 0) {
            registerResp.setSuccess("0");
        } else {
            registerResp.setSuccess("1");
        }
        //主要前端对字段success进行判断
        return new BaseResponse(registerResp);
    }

    @ApiOperation(value = "注册时,远程验证手机号/邮箱是否存在")
    @RequestMapping(value = "/remote", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<RRemoteResp> remote(HttpServletRequest request, @Valid @RequestBody RegisterRemoteEntity registerRemoteEntity, BindingResult errors) {
        //服务端验证,通用参数异常处理,跳到了全局异常处理,code=500(貌似登陆不验证)
        RequestDeal.requestDeal(errors);
        RRemoteResp rRemoteResp = new RRemoteResp();
        boolean flag = userService.getRemote(registerRemoteEntity.getEmailphone());
        rRemoteResp.setFlag(flag);
        //主要前端对字段success进行判断
        return new BaseResponse(rRemoteResp);
    }


    @ApiOperation(value = "前端异步获取后台session")
    @RequestMapping(value = "/getSession", method = RequestMethod.GET)
    @ResponseBody
    public User getSession(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        return user;
    }

}
