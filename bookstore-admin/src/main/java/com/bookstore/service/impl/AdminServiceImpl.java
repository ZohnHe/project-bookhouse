package com.bookstore.service.impl;

import com.bookstore.dao.mapping.UserMapper;
import com.bookstore.dao.mapping.ext.AdminMapperExt;
import com.bookstore.dao.pojo.User;
import com.bookstore.domain.UserAddEntity;
import com.bookstore.domain.UserModifyEntity;
import com.bookstore.domain.UserQueryEntity;
import com.bookstore.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

import java.util.List;

/**
 * AdminService 实现类
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    UserMapper userMapper;

    @Resource
    AdminMapperExt adminMapperExt;

    /**
     * 获取用户列表
     *
     * @param userQueryEntity
     * @return
     */
    @Override
    public PageInfo<User> getUserList(UserQueryEntity userQueryEntity) {
        PageHelper.startPage(userQueryEntity.getPageNum(), userQueryEntity.getPageSize());
        List<User> users ;

        String uname = userQueryEntity.getSearch();
        if (uname == null) {
            users = userMapper.selectAll();
        } else {
            Example example = new Example(User.class);
            Example.Criteria criteria = example.createCriteria();

            criteria.andLike("uname", "%" + uname + "%");

            users = userMapper.selectByExample(example);
        }
        return new PageInfo<User>(users);
    }


    /**
     * 删除指定用户
     *
     * @param goodsIds
     * @return
     */
    @Override
    public int userDelete(String[] goodsIds) {
        return adminMapperExt.userDelete(goodsIds);
    }

    /**
     * 添加用户
     *
     * @param userAddEntity
     * @return
     */
    @Override
    public int userAdd(UserAddEntity userAddEntity) {

        return adminMapperExt.userAdd(userAddEntity);
    }

    /**
     * 修改用户
     *
     * @param userModifyEntity
     * @return
     */
    @Override
    public int userModify(UserModifyEntity userModifyEntity) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("uid", userModifyEntity.getUid());
        List<User> list = userMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            User user = list.get(0);
            BeanUtils.copyProperties(userModifyEntity, user);
            return userMapper.updateByExample(user, example);
        }
        return 0;
    }
}
