package com.example.goods.Service;

import com.example.goods.Dao.GoodsDetaNameDao;
import com.example.goods.Service.Impl.GoodsDetaNameImpl;
import com.example.goods.pojo.Gooddetaliname;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GoodDetaNameService implements GoodsDetaNameImpl {
    @Autowired
    private GoodsDetaNameDao goodsDetaNameDao;
    @Override
    public List<Gooddetaliname> findAll() {
        return null;
    }

    @Override
    public Gooddetaliname findById(int id) {
        return null;
    }

    @Override
    public String add(Gooddetaliname gooddetaliname) {
        int insert = goodsDetaNameDao.insert(gooddetaliname);
        return insert!=0?"200":"400";
    }

    @Override
    public String update(Gooddetaliname gooddetaliname) {
        return null;
    }

    @Override
    public String deleteId(int id) {
        return null;
    }
}
