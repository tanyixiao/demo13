package com.example.goods.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.goods.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
