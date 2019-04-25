package com.bookstore.controller;

import com.bookstore.common.BaseResponse;
import com.bookstore.common.constant.ResponseCode;
import com.bookstore.domain.ManagerEntity;
import com.bookstore.response.LoginManagerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@Api(tags = "后台登录模块")
public class LoginController {

    @RequestMapping(value = "/backLoginPage", method = RequestMethod.GET)
    public String loginPage() {
        return "admin/login";
    }

    @ApiOperation(value = "管理员登录")
    @RequestMapping(value = "/backLogin", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<LoginManagerResponse> login(HttpServletRequest request, @Valid @RequestBody ManagerEntity manager, BindingResult errors) {
        //提取传入的管理员用户参数
        String username = manager.getUsername();
        String password = manager.getPassword();

        LoginManagerResponse loginResponse = new LoginManagerResponse();

        //如果管理员登陆传入参数不符规范则返回错误信息
        if (errors.hasErrors()) {
            List<ObjectError> errorList = errors.getAllErrors();
            StringBuilder sb = new StringBuilder();
            for (ObjectError error : errorList) {
                FieldError fieldError = (FieldError) error;

                sb.append(fieldError.getDefaultMessage() + "|");
            }
            loginResponse.setSuccess("0");
            loginResponse.setMsg(sb.toString());

            BaseResponse baseResponse = new BaseResponse(loginResponse);
            baseResponse.setCode(ResponseCode.FAIL.getCode());
            baseResponse.setMsg("参数输入错误");

            return baseResponse;
        }

        //登录成功
        if (username.equals(password) && username.equals("admin")) {
            loginResponse.setSessionId("admin");
            loginResponse.setSuccess("1");
        }
        //登录失败
        else {
            loginResponse.setSuccess("0");
            loginResponse.setMsg("用户名或密码错误");
        }
        return new BaseResponse(loginResponse);
    }


}
