package com.example.goods.Service.Impl;

import com.example.goods.common.Resulet04;
import com.example.goods.pojo.OrderCart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author xiao
* @description 针对表【order_cart(购物车)】的数据库操作Service
* @createDate 2021-11-05 21:13:06
*/
public interface OrderCartService {
    Resulet04<OrderCart> page(String id,int start,int num);

    int add(OrderCart orderCart);

    int update(int id, OrderCart orderCart);

    int delete(int id);

}
