package com.example.goods.Service.Impl;

import com.example.goods.common.Resulet04;
import com.example.goods.pojo.OrderMaster;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xiao
* @description 针对表【order_master(订单主表)】的数据库操作Service
* @createDate 2021-11-25 16:49:10
*/
public interface OrderMasterService{
    Resulet04<OrderMaster> page(String id, int start, int size);
    int add(List<OrderMaster> orderMaster);
    int update(int id, OrderMaster orderMaster);
    int delete(int id);
}
