package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {

    /**
     * 查询所有产品信息
     * @return
     */
    @Select("select * from product")
    public List<Product> findAll() throws Exception;
}
