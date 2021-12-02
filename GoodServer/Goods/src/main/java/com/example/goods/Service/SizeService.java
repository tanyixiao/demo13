package com.example.goods.Service;

import com.example.goods.Dao.sizeDao;
import com.example.goods.Service.Impl.GoodImpl;
import com.example.goods.Service.Impl.SizeImpl;
import com.example.goods.pojo.Good_size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SizeService implements SizeImpl {
    @Autowired
    private sizeDao sizeDao;
    @Override
    public List<Good_size> findAll() {
        return null;
    }

    @Override
    public Good_size findById(int id) {
        return null;
    }

    @Override
    public String add(Good_size goodSize) {
        int insert = sizeDao.insert(goodSize);
        return insert!=0?"200":"400";
    }

    @Override
    public String update(Good_size goodSize) {
        return null;
    }

    @Override
    public String deleteId(int id) {
        return null;
    }
}
