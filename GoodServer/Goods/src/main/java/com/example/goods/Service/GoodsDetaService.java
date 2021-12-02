package com.example.goods.Service;

import com.example.goods.Dao.GoodsDetaDao;
import com.example.goods.Service.Impl.GoodsDetaImpl;
import com.example.goods.pojo.Good_detali;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GoodsDetaService implements GoodsDetaImpl {
    @Autowired
    private GoodsDetaDao goodsDetaDao;
    @Override
    public List<Good_detali> findAll() {
        return null;
    }

    @Override
    public Good_detali findById(int id) {
        return null;
    }

    @Override
    public String add(Good_detali goodDetali) {
        int insert = goodsDetaDao.insert(goodDetali);
        return insert!=0?"200":"400";
    }

    @Override
    public String update(Good_detali goodDetali) {
        return null;
    }

    @Override
    public String deleteId(int id) {
        return null;
    }
}
