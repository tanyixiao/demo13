package com.example.goods.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.goods.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface goodsDao extends BaseMapper<Goods> {
}
