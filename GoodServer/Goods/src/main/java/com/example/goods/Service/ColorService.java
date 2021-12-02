package com.example.goods.Service;

import com.example.goods.Dao.ColorDao;
import com.example.goods.Service.Impl.colorImpl;
import com.example.goods.pojo.Good_color;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ColorService implements colorImpl {
    @Autowired
    private ColorDao colorDao;
    @Override
    public List<Good_color> findAll() {
        return null;
    }

    @Override
    public Good_color findById(int id) {
        return null;
    }

    @Override
    public String addColor(Good_color goodColor) {
        int insert = colorDao.insert(goodColor);
        return insert!=0?"200":"400";
    }

    @Override
    public String updateColor(Good_color goodColor) {
        return null;
    }

    @Override
    public String deleteId(int id) {
        return null;
    }
}
