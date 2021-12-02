package com.example.goods.Dao;

import com.example.goods.pojo.BrandInfo;
import com.example.goods.pojo.ProductPicInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xiao
* @description 针对表【product_pic_info(商品图片信息表)】的数据库操作Mapper
* @createDate 2021-12-01 10:35:19
* @Entity com.example.goods.pojo.ProductPicInfo
*/
@Mapper
public interface ProductPicInfoMapper extends BaseMapper<ProductPicInfo> {
    List<ProductPicInfo> listPic(@Param("id") String id);
    Long Count();
    ProductPicInfo selectByIds(@Param("id") Integer id);
    int add(@Param("picInfoss") List<ProductPicInfo> picInfos);
    int update(@Param("id") int id, @Param("picInfos")ProductPicInfo picInfos);
    int delete(@Param("id") int id);
}




