package com.example.goods.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.goods.pojo.Good_comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface commentDao extends BaseMapper<Good_comment> {
}
