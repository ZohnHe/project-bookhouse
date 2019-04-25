package com.bookstore.service.impl;

import com.bookstore.dao.mapping.UserMapper;
import com.bookstore.dao.mapping.ext.UserMapperExt;
import com.bookstore.dao.pojo.User;
import com.bookstore.domain.LoginEntity;
import com.bookstore.domain.RegisterEntity;
import com.bookstore.domain.UserQueryEntity;
import com.bookstore.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserService 实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    UserMapperExt userMapperExt;



    //email和phone对应的规则来赋值
    String ph = "^[1][3578]\\d{9}$";
    List<User> list = null;

    /**
     * 获取用户,通过手机号/邮箱 ,和密码
     * @param loginEntity 手机号/邮箱 ,和密码的接收实体
     * @return user对象
     */
    @Override
    public User getUserInfo(LoginEntity loginEntity) {
        //账号或email不为空,进行数据库操作
        if (!StringUtils.isEmpty(loginEntity.getEmailphone())) {

            if (loginEntity.getEmailphone().matches(ph)) {
                list = userMapperExt.getUserInfoPh(loginEntity.getEmailphone(), loginEntity.getPassword());
            } else {
                list = userMapperExt.getUserInfoEm(loginEntity.getEmailphone(), loginEntity.getPassword());
            }
            if (list != null && list.size() > 0) {
                return list.get(0);
            }
        }
        return null;
    }

    /**
     * 通过手机号/邮箱,获取盐值
     * @param emailphone 手机号/邮箱
     * @return 盐值
     */
    @Override
    public String getSaltByEmailPhone(String emailphone) {
        String salt = null;
        if (emailphone.matches(ph)) {
            list = userMapperExt.getSaltByPh(emailphone);
        } else {
            list = userMapperExt.getSaltByEm(emailphone);
        }
        if (list != null && list.size() > 0) {
            salt = list.get(0).getSalt();
        }

        return salt;
    }

    /**
     * 通过手机号/邮箱,进行远程验证
     * @param emailphone 手机号/邮箱
     * @return 是否已存在
     */
    @Override
    public boolean getRemote(String emailphone) {
        if(emailphone.matches(ph)){
            list=userMapperExt.getRemoteByPh(emailphone);
        }else{
            list=userMapperExt.getRemoteByEm(emailphone);
        }
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 通过注册接收实体,进行注册(需要进行判断是否用户已存在)
     * @param registerEntity 手机号/邮箱,密码,盐值
     * @return 结果集
     */
    @Override
    public Integer getRegister(RegisterEntity registerEntity) {
        Integer result=0;
        Example example = new Example(User.class);
        //判断是email or phone
        if(registerEntity.getEmailphone().matches(ph)){
            example.createCriteria().andEqualTo("phone",registerEntity.getEmailphone());
            list = userMapper.selectByExample(example);
            //不存在,则插入
            if (list == null || list.size() == 0) {
                result=userMapperExt.insertPh(registerEntity.getEmailphone(),registerEntity.getPassword(),registerEntity.getSalt());
                return result;
            }
        }else{
            example.createCriteria().andEqualTo("email",registerEntity.getEmailphone());
            list = userMapper.selectByExample(example);
            //不存在,则插入
            if (list == null || list.size() == 0) {
                result=userMapperExt.insertEm(registerEntity.getEmailphone(),registerEntity.getPassword(),registerEntity.getSalt());
                return result;
            }
        }
        return 0;
    }
}
