package com.example.goods.Dao;

import com.example.goods.pojo.OrderMaster;
import com.example.goods.pojo.ProductInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xiao
* @description 针对表【product_info(商品信息表)】的数据库操作Mapper
* @createDate 2021-11-30 21:04:37
* @Entity com.example.goods.pojo.ProductInfo
*/
@Mapper
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
    List<ProductInfo> page(@Param("id") String id, @Param("start") int start, @Param("size")int size);
    Long Count();
    ProductInfo selectByIds(@Param("id") Integer id);
    int add(@Param("productInfoss") List<ProductInfo> productInfos);
    int update(@Param("id") int id, @Param("productInfos")ProductInfo productInfos);
    int delete(@Param("id") int id);
}




