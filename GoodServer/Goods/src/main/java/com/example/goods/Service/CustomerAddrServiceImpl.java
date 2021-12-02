package com.example.goods.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goods.common.Resulet04;
import com.example.goods.pojo.CustomerAddr;
import com.example.goods.Service.Impl.CustomerAddrService;
import com.example.goods.Dao.CustomerAddrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author xiao
* @description 针对表【customer_addr(用户地址表)】的数据库操作Service实现
* @createDate 2021-11-24 22:13:48
*/
@Service
public class CustomerAddrServiceImpl implements CustomerAddrService{
    @Autowired
    private CustomerAddrMapper customerAddrMapper;
    @Override
    public Resulet04<CustomerAddr> page(String id ,int start, int num) {
        List<CustomerAddr> page = customerAddrMapper.page(id,start, num);
        Long count = customerAddrMapper.Count();
        Resulet04<CustomerAddr> resulet04 = new Resulet04<>();
        return resulet04.setTList(page).setCount(count).setMsg("成功");
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int add(CustomerAddr customerAddr) {
        return customerAddrMapper.add(customerAddr);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(int id, CustomerAddr orderMaster) {
        return customerAddrMapper.update(id, orderMaster);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int delete(int id) {
        return customerAddrMapper.delete(id);
    }
}




