package com.bookstore.controller;

import com.bookstore.common.BaseResponse;
import com.bookstore.dao.pojo.User;
import com.bookstore.domain.UserAddEntity;
import com.bookstore.domain.UserDeleteEntity;
import com.bookstore.domain.UserModifyEntity;
import com.bookstore.domain.UserQueryEntity;
import com.bookstore.domain.vo.UserVo;
import com.bookstore.response.UserAddResp;
import com.bookstore.response.UserDeleteResp;
import com.bookstore.response.UserListResponse;
import com.bookstore.response.UserModifyResp;
import com.bookstore.service.AdminService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;

@Api(tags = "用户管理模块")
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Resource
    AdminService adminService;

    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "/userList", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<UserListResponse<UserVo>> getUserList(HttpServletRequest request, @Valid @RequestBody UserQueryEntity userQueryEntity, BindingResult errors) {

        PageInfo<User> list = adminService.getUserList(userQueryEntity);

        // 返回类型转换(控制返回字段)
        ArrayList<UserVo> data = new ArrayList<>();
        if (list != null) {
            for (User user : list.getList()) {
                UserVo userVo = new UserVo();
                try {
                    BeanUtils.copyProperties(user, userVo);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                data.add(userVo);
            }
        }

        UserListResponse<UserVo> userListResponse = new UserListResponse(data);
        userListResponse.setPageNum(userQueryEntity.getPageNum());
        userListResponse.setPageSize(userQueryEntity.getPageSize());

        userListResponse.setPageNum(userQueryEntity.getPageNum());
        userListResponse.setPageSize(userQueryEntity.getPageSize());
        userListResponse.setTotalRecord(list.getTotal());
        // 多少页 (总记录数+分页数-1)/分页数
        long totalPage = (userListResponse.getTotalRecord() + userQueryEntity.getPageSize() - 1) / userQueryEntity.getPageSize();


        return new BaseResponse(userListResponse);

    }

    @ApiOperation(value = "删除指定用户")
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<UserDeleteResp> userDel(HttpServletRequest request, @Valid @RequestBody UserDeleteEntity userDeleteEntity, BindingResult errors) {

        //请求参数异常处理，加错误提示
        // RequestAssets.assetsError(errors);
        UserDeleteResp userDeleteResp = new UserDeleteResp();
        userDeleteResp.setResult(adminService.userDelete(userDeleteEntity.getUserIds()));

        return new BaseResponse(userDeleteResp);
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<UserAddResp> addUser(HttpServletRequest request, @Valid @RequestBody UserAddEntity userAddEntity, BindingResult errors) {

        UserAddResp userAddResp = new UserAddResp();
        userAddResp.setResult(adminService.userAdd(userAddEntity));
        return new BaseResponse(userAddResp);
    }

    @ApiOperation(value = "修改用户信息")
    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<UserModifyResp> modifyUser(HttpServletRequest request, @Valid @RequestBody UserModifyEntity userModifyEntity, BindingResult errors) {

        UserModifyResp userModifyResp = new UserModifyResp();
        userModifyResp.setResult(adminService.userModify(userModifyEntity));
        return new BaseResponse(userModifyResp);
    }
}