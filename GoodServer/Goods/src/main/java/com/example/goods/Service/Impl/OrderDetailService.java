package com.example.goods.Service.Impl;

import com.example.goods.common.Resulet04;
import com.example.goods.pojo.OrderDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xiao
* @description 针对表【order_detail(订单详情表)】的数据库操作Service
* @createDate 2021-11-25 18:14:34
*/
public interface OrderDetailService {
    Resulet04<OrderDetail> page(String id, int start, int size);
    int add(List<OrderDetail> orderDetails);
    int update(String id,OrderDetail orderDetails);
    int delete(int id);
}
