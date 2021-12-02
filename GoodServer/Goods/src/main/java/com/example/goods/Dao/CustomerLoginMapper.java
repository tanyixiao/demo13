package com.example.goods.Dao;

import com.example.goods.pojo.CustomerLogin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xiao
* @description 针对表【customer_login(用户登录表)】的数据库操作Mapper
* @createDate 2021-11-08 13:10:32
* @Entity com.example.goods.pojo.CustomerLogin
*/
@Mapper
public interface CustomerLoginMapper extends BaseMapper<CustomerLogin> {
    CustomerLogin selectByName(@Param("username") String username, @Param("password") String password);
    List<String> ByName(@Param("username") String username);
}




