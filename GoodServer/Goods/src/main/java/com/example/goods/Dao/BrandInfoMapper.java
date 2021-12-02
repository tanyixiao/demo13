package com.example.goods.Dao;

import com.example.goods.pojo.BrandInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.goods.pojo.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xiao
* @description 针对表【brand_info(品牌信息表)】的数据库操作Mapper
* @createDate 2021-12-01 10:06:04
* @Entity com.example.goods.pojo.BrandInfo
*/
@Mapper
public interface BrandInfoMapper extends BaseMapper<BrandInfo> {
    List<BrandInfo> page(@Param("id") String id, @Param("start") int start, @Param("size")int size);
    Long Count();
    BrandInfo selectByIds(@Param("id") Integer id);
    int add(@Param("brandInfoss") List<BrandInfo> brandInfos);
    int update(@Param("id") int id, @Param("brandInfos")BrandInfo brandInfos);
    int delete(@Param("id") int id);
}




