package com.example.goods.Service.Impl;

import com.example.goods.common.Resulet04;
import com.example.goods.pojo.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xiao
* @description 针对表【product_category(商品分类表)】的数据库操作Service
* @createDate 2021-12-01 11:10:53
*/
public interface ProductCategoryService {
    Resulet04<ProductCategory> page(String id, int start, int size);
    int add(List<ProductCategory> productCategories);
    int update(int id, ProductCategory productCategories);
    int delete(int id);
}
