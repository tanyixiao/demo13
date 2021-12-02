package com.example.goods.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goods.common.Resulet04;
import com.example.goods.pojo.ProductInfo;
import com.example.goods.Service.Impl.ProductInfoService;
import com.example.goods.Dao.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author xiao
* @description 针对表【product_info(商品信息表)】的数据库操作Service实现
* @createDate 2021-11-30 21:04:37
*/
@Service
public class ProductInfoServiceImpl implements ProductInfoService{
    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Override
    public Resulet04<ProductInfo> page(String id, int start, int size) {
        Resulet04<ProductInfo> resulet04 = new Resulet04<>();
        List<ProductInfo> page = productInfoMapper.page(id, start, size);
        Long count = productInfoMapper.Count();
        return resulet04.setCount(count).setTList(page);
    }

    @Override
    public int add(List<ProductInfo> productInfos) {
        return productInfoMapper.add(productInfos);
    }

    @Override
    public int update(int id, ProductInfo productInfos) {
        return productInfoMapper.update(id, productInfos);
    }

    @Override
    public int delete(int id) {
        return productInfoMapper.delete(id);
    }
}




