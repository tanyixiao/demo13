package com.example.goods.Dao;

import com.example.goods.pojo.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.goods.pojo.OrderMaster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xiao
* @description 针对表【order_detail(订单详情表)】的数据库操作Mapper
* @createDate 2021-11-25 18:14:34
* @Entity com.example.goods.pojo.OrderDetail
*/
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
    List<OrderDetail> page(@Param("id") String id, @Param("start") int start, @Param("size") int size);
    Long Count();
    int add(@Param("orderDetailss") List<OrderDetail> orderDetails);
    int update(@Param("id") String id, @Param("orderDetails") OrderDetail orderDetails);
    int delete(@Param("id") int id);
}




