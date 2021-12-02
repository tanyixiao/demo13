package com.example.goods.Dao;

import com.example.goods.pojo.ProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.goods.pojo.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xiao
* @description 针对表【product_category(商品分类表)】的数据库操作Mapper
* @createDate 2021-12-01 11:10:53
* @Entity com.example.goods.pojo.ProductCategory
*/
@Mapper
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {
    List<ProductCategory> page(@Param("id") String id, @Param("start") int start, @Param("size")int size);
    Long Count();
    ProductCategory selectByIds(@Param("id") Integer id);
    List<ProductCategory> selectByIds1(@Param("id") Integer id);
    int add(@Param("productCategoriess") List<ProductCategory> productCategories);
    int update(@Param("id") int id, @Param("productCategories")ProductCategory productCategories);
    int delete(@Param("id") int id);
}




