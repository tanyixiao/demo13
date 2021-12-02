package com.example.goods.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goods.pojo.CustomerLogin;
import com.example.goods.Service.Impl.CustomerLoginService;
import com.example.goods.Dao.CustomerLoginMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Optional;

/**
* @author xiao
* @description 针对表【customer_login(用户登录表)】的数据库操作Service实现
* @createDate 2021-11-08 13:10:32
*/
@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{
    @Autowired
    private CustomerLoginMapper customerLoginMapper;
    @Override
    public CustomerLogin selectByName(String username, String password) {
        CustomerLogin CustomerLogin = customerLoginMapper.selectByName(username, password);
        if (CustomerLogin==null){
            return new CustomerLogin();
        }
        return CustomerLogin;
    }
}




