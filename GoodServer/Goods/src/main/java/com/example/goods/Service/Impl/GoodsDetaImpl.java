package com.example.goods.Service.Impl;

import com.example.goods.pojo.Good_color;
import com.example.goods.pojo.Good_detali;

import java.util.List;

public interface GoodsDetaImpl {
    List<Good_detali> findAll();
    Good_detali findById(int id);
    String add(Good_detali goodDetali);
    String update(Good_detali goodDetali);
    String deleteId(int id);
}
