package com.example.goods.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goods.Dao.*;
import com.example.goods.common.Resulet04;
import com.example.goods.pojo.*;
import com.example.goods.Service.Impl.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author xiao
* @description 针对表【order_detail(订单详情表)】的数据库操作Service实现
* @createDate 2021-11-25 18:14:34
*/
@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private OrderMasterMapper orderMasterMapper;
    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Autowired
    private BrandInfoMapper brandInfoMapper;
    @Override
    public Resulet04<OrderDetail> page(String id, int start, int size) {
        Resulet04<OrderDetail> resulet04 = new Resulet04<>();
        List<OrderDetail> page = orderDetailMapper.page(id, start, size);
        page.forEach(orderDetail -> {
            ProductInfo page1 = productInfoMapper.selectByIds(orderDetail.getProductId());
            BrandInfo brandInfo = brandInfoMapper.selectByIds(orderDetail.getProductId());
            page1.setBrandInfo(brandInfo);
            List<ProductCategory> page2 = productCategoryMapper.page(String.valueOf(orderDetail.getProductId()),start,size);
            page1.setProductCategoryList(page2);
            orderDetail.setProductInfo(page1).setOrderMaster(orderMasterMapper.selectByIds(orderDetail.getOrderId()));
        });
        Long count = orderDetailMapper.Count();
        return resulet04.setTList(page).setCount(count).setMsg("成功");
    }

    @Override
    public int add(List<OrderDetail> orderDetails) {
        return orderDetailMapper.add(orderDetails);
    }

    @Override
    public int update(String id,OrderDetail orderDetails) {
        return orderDetailMapper.update(id, orderDetails);
    }

    @Override
    public int delete(int id) {
        return orderDetailMapper.delete(id);
    }
}




