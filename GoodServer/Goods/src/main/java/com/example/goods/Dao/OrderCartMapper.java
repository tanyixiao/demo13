package com.example.goods.Dao;

import com.example.goods.pojo.OrderCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author xiao
* @description 针对表【order_cart(购物车)】的数据库操作Mapper
* @createDate 2021-11-05 21:13:06
* @Entity com.example.goods.pojo.OrderCart
*/
@Mapper
public interface OrderCartMapper extends BaseMapper<OrderCart> {
    List<OrderCart> page(@Param("id") String id,@Param("start") int start, @Param("size")int size);
    int add(@Param("orderCart") OrderCart orderCart);
    int update(@Param("id") int id, @Param("orderCart")OrderCart orderCart);
    int delete(@Param("id") int id);
}




