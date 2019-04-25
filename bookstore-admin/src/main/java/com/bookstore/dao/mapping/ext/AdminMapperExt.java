package com.bookstore.dao.mapping.ext;

import com.bookstore.domain.UserAddEntity;
import com.bookstore.domain.UserModifyEntity;
import com.bookstore.domain.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AdminMapperExt extends Mapper<UserVo> {
    /* 用户搜索 */
    List<UserVo> userSearch(@Param("uname") String uname
            , @Param("orderStr") String orderStr); //param1/2

    /* 用户联合查询 */
    List<UserVo> userSearchUn(@Param("uname") String uname
            ,@Param("orderStr") String orderStr); //param1/2

    /* 用户删除 */
    Integer userDelete(@Param("userIds")String[] userIds);

    /**
     * 用户添加
     * @param userAddEntity
     * @return
     */
    int userAdd(@Param("userAddEntity") UserAddEntity userAddEntity);

    /**
     * 用户修改
     * @param userModifyEntity
     * @return
     */
    int userModify(@Param("userModifyEntity") UserModifyEntity userModifyEntity);
}
