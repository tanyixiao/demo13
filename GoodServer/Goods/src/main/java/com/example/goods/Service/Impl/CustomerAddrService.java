package com.example.goods.Service.Impl;

import com.example.goods.common.Resulet04;
import com.example.goods.pojo.CustomerAddr;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.goods.pojo.OrderMaster;

/**
* @author xiao
* @description 针对表【customer_addr(用户地址表)】的数据库操作Service
* @createDate 2021-11-24 22:13:48
*/
public interface CustomerAddrService {
    Resulet04<CustomerAddr> page(String id,int start, int num);
    int add(CustomerAddr customerAddr);

    int update(int id, CustomerAddr orderMaster);

    int delete(int id);

}
