package com.example.goods.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goods.Dao.ProductInfoMapper;
import com.example.goods.common.Resulet04;
import com.example.goods.pojo.ProductCategory;
import com.example.goods.Service.Impl.ProductCategoryService;
import com.example.goods.Dao.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author xiao
* @description 针对表【product_category(商品分类表)】的数据库操作Service实现
* @createDate 2021-12-01 11:10:53
*/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Override
    public Resulet04<ProductCategory> page(String id, int start, int size) {
        Resulet04<ProductCategory> resulet04 = new Resulet04<>();
        List<ProductCategory> page = productCategoryMapper.page(id, start, size);
        long count = page.stream().count();
        return resulet04.setTList(page).setCount(count).setMsg("成功");
    }

    @Override
    public int add(List<ProductCategory> productCategories) {
        return productCategoryMapper.add(productCategories);
    }

    @Override
    public int update(int id, ProductCategory productCategories) {
        return productCategoryMapper.update(id, productCategories);
    }

    @Override
    public int delete(int id) {
        return productCategoryMapper.delete(id);
    }
}




