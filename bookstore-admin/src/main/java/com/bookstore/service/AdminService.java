package com.bookstore.service;

import com.bookstore.dao.pojo.User;
import com.bookstore.domain.UserAddEntity;
import com.bookstore.domain.UserModifyEntity;
import com.bookstore.domain.UserQueryEntity;
import com.github.pagehelper.PageInfo;

public interface AdminService {
    /**
     * 获取用户列表
     * @return User
     */
    PageInfo<User> getUserList(UserQueryEntity userQueryEntity);

    /**
     * 删除指定用户
     * @param goodsIds
     * @return
     */
    int userDelete(String[] goodsIds);

    /**
     * 添加用户
     * @param userAddEntity
     * @return
     */
    int userAdd(UserAddEntity userAddEntity);

    /**
     * 用户修改
     * @param userModifyEntity
     * @return
     */
    int userModify(UserModifyEntity userModifyEntity);
}
