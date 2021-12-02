package com.example.goods.Service.Impl;

import com.example.goods.pojo.CustomerLogin;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
* @author xiao
* @description 针对表【customer_login(用户登录表)】的数据库操作Service
* @createDate 2021-11-08 13:10:32
*/
public interface CustomerLoginService {

    CustomerLogin selectByName(String username,String password);
}
