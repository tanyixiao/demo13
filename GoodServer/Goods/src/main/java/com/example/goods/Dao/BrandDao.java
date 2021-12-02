package com.example.goods.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.goods.pojo.GoodBrand;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrandDao extends BaseMapper<GoodBrand> {
}
