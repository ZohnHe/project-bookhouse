package com.bookstore.dao.mapping.ext;

import com.bookstore.dao.pojo.BookOrder;
import com.bookstore.dao.pojo.ext.UnionInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BookOrderMapperExt extends Mapper<BookOrder> {
    //通过oid修改3个数据
    Integer updateOrderByOid(@Param("oid") Integer oid,
                             @Param("oname") String oname,
                             @Param("adress") String adress,
                             @Param("status") String status);

    List<UnionInfo> searchUn(@Param("oid") Integer oid);
}