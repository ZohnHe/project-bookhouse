package com.bookstore.service;

import com.bookstore.dao.pojo.User;
import com.bookstore.domain.LoginEntity;
import com.bookstore.domain.RegisterEntity;
import com.bookstore.domain.UserQueryEntity;
import com.github.pagehelper.PageInfo;

/**
 * 用户 Service 接口
 */
public interface UserService {


    /**
     * 获取用户,通过手机号/邮箱 ,和密码
     * @param loginEntity 手机号/邮箱 ,和密码的接收实体
     * @return user对象
     */
    User getUserInfo(LoginEntity loginEntity);
    /**
     * 通过手机号/邮箱,获取盐值
     * @param emailphone 手机号/邮箱
     * @return 盐值
     */
    String getSaltByEmailPhone(String emailphone);
    /**
     * 通过手机号/邮箱,进行远程验证
     * @param emailphone 手机号/邮箱
     * @return 是否已存在
     */
    boolean getRemote(String emailphone);
    /**
     * 通过注册接收实体,进行注册(需要进行判断是否用户已存在)
     * @param registerEntity 手机号/邮箱,密码,盐值
     * @return 结果集
     */
    Integer getRegister(RegisterEntity registerEntity);
}
