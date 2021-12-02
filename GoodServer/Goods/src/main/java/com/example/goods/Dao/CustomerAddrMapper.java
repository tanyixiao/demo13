package com.example.goods.Dao;

import com.example.goods.common.Resulet04;
import com.example.goods.pojo.CustomerAddr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.goods.pojo.OrderCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xiao
* @description 针对表【customer_addr(用户地址表)】的数据库操作Mapper
* @createDate 2021-11-24 22:13:48
* @Entity com.example.goods.pojo.CustomerAddr
*/
@Mapper
public interface CustomerAddrMapper extends BaseMapper<CustomerAddr> {
    List<CustomerAddr> page(@Param("id")String id ,@Param("start") int start, @Param("size")int size);
    Long Count();
    int add(@Param("customerAddr") CustomerAddr customerAddr);
    int update(@Param("id") int id, @Param("customerAddr")CustomerAddr customerAddr);
    int delete(@Param("id") int id);
}




