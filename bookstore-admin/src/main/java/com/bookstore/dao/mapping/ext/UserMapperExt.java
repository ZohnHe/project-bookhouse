package com.bookstore.dao.mapping.ext;

import com.bookstore.dao.pojo.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/19 9:37
 * @Version 1.0.0
 * 拓展的 UserMapper,写自己定义的方法
 */
public interface UserMapperExt extends Mapper<User> {
    //email or phone 登陆
    List<User> getUserInfoPh(@Param("phone") String phone,
                             @Param("password") String password);

    List<User> getUserInfoEm(@Param("email") String email,
                             @Param("password") String password);

    //get salt
    List<User> getSaltByPh(@Param("phone") String phone);

    List<User> getSaltByEm(@Param("email") String email);

    // remote
    List<User> getRemoteByPh(@Param("phone") String phone);

    List<User> getRemoteByEm(@Param("email") String email);

    // insert
    Integer insertPh(@Param("phone") String emailphone,
                     @Param("password") String password,
                     @Param("salt") String salt);

    Integer insertEm(@Param("email") String emailphone,
                     @Param("password") String password,
                     @Param("salt") String salt);
}
