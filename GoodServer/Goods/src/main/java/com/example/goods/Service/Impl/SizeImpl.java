package com.example.goods.Service.Impl;

import com.example.goods.pojo.Good_detali;
import com.example.goods.pojo.Good_size;

import java.util.List;

public interface SizeImpl {
    List<Good_size> findAll();
    Good_size findById(int id);
    String add(Good_size goodSize);
    String update(Good_size goodSize);
    String deleteId(int id);

}
