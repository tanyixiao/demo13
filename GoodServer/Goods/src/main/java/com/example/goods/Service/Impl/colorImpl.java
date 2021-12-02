package com.example.goods.Service.Impl;

import com.example.goods.pojo.GoodBrand;
import com.example.goods.pojo.Good_color;

import java.util.List;
import java.util.Map;

public interface colorImpl {
    List<Good_color> findAll();
    Good_color findById(int id);
    String addColor(Good_color goodColor);
    String updateColor(Good_color goodColor);
    String deleteId(int id);

}
