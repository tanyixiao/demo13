package com.example.goods.Service.Impl;

import com.example.goods.common.Resulet04;
import com.example.goods.pojo.ProductInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xiao
* @description 针对表【product_info(商品信息表)】的数据库操作Service
* @createDate 2021-11-30 21:04:37
*/
public interface ProductInfoService {
    Resulet04<ProductInfo> page(String id, int start, int size);
    int add(List<ProductInfo> productInfos);
    int update(int id, ProductInfo productInfos);
    int delete(int id);
}
