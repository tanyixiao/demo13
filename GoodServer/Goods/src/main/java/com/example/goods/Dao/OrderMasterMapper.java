package com.example.goods.Dao;

import com.example.goods.pojo.OrderCart;
import com.example.goods.pojo.OrderMaster;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xiao
* @description 针对表【order_master(订单主表)】的数据库操作Mapper
* @createDate 2021-11-25 16:49:10
* @Entity com.example.goods.pojo.OrderMaster
*/
@Mapper
public interface OrderMasterMapper extends BaseMapper<OrderMaster> {
    List<OrderMaster> page(@Param("id") String id, @Param("start") int start, @Param("size")int size);
    Long Count();
    OrderMaster selectByIds(@Param("id") Integer id);
    int add(@Param("orderMasters") List<OrderMaster> orderMaster);
    int update(@Param("id") int id, @Param("orderMaster")OrderMaster orderMaster);
    int delete(@Param("id") int id);
}




