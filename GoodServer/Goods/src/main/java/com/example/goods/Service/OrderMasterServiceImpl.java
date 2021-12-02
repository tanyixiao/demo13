package com.example.goods.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goods.Dao.OrderDetailMapper;
import com.example.goods.common.Resulet04;
import com.example.goods.pojo.OrderDetail;
import com.example.goods.pojo.OrderMaster;
import com.example.goods.Service.Impl.OrderMasterService;
import com.example.goods.Dao.OrderMasterMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* @author xiao
* @description 针对表【order_master(订单主表)】的数据库操作Service实现
* @createDate 2021-11-25 16:49:10
*/
@Service
public class OrderMasterServiceImpl implements OrderMasterService{
    @Autowired
    private OrderMasterMapper orderMasterMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Override
    public Resulet04<OrderMaster> page(String id, int start, int size) {
        Resulet04<OrderMaster> resulet04 = new Resulet04<>();
        List<OrderMaster> page = orderMasterMapper.page(id, start, size);
        Long count = orderMasterMapper.Count();
        return resulet04.setCount(count).setTList(page).setMsg("成功");
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int add(List<OrderMaster> orderMaster) {
        List<OrderDetail> detail = new ArrayList<>();
        OrderDetail detail1 = new OrderDetail();
        int add = orderMasterMapper.add(orderMaster);
        orderMaster.forEach(orderMaster1 -> {
            detail1.setOrderId(orderMaster1.getOrderId()).setProductId(orderMaster1.getOrderId())
                    .setProductPrice(orderMaster1.getPaymentMoney()).setModifiedTime(orderMaster1.getModifiedTime())
                    .setProductCnt(orderMaster1.getOrderPoint());
            detail.add(detail1);
        });
        int add1 = orderDetailMapper.add(detail);
        return add1;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(int id, OrderMaster orderMaster) {
        return orderMasterMapper.update(id, orderMaster);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int delete(int id) {
        return orderMasterMapper.delete(id);
    }
}




