package com.example.goods.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.goods.pojo.Good_inventory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface inventoryDao extends BaseMapper<Good_inventory> {
}
