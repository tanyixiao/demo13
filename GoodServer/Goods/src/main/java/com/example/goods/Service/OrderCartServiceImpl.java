package com.example.goods.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goods.common.Resulet04;
import com.example.goods.pojo.OrderCart;
import com.example.goods.Service.Impl.OrderCartService;
import com.example.goods.Dao.OrderCartMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
* @author xiao
* @description 针对表【order_cart(购物车)】的数据库操作Service实现
* @createDate 2021-11-05 21:13:06
*/
@Service
public class OrderCartServiceImpl implements OrderCartService{
    @Autowired
    private OrderCartMapper orderCartMapper;
    @Override
    public Resulet04<OrderCart> page(String id,int start, int num) {
        List<OrderCart> cartList = orderCartMapper.page(id,start, num);
        Resulet04<OrderCart> resulet04 = new Resulet04<>();
        return resulet04.setMsg("成功").setTList(cartList);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int add(OrderCart orderCart) {
        return orderCartMapper.add(orderCart);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(int id, OrderCart orderCart) {
        return orderCartMapper.update(id, orderCart);

    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int delete(int id) {
        return orderCartMapper.delete(id);
    }

}




