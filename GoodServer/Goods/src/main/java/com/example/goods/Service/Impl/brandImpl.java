package com.example.goods.Service.Impl;

import com.example.goods.common.Resulet01;
import com.example.goods.pojo.GoodBrand;
import com.example.goods.pojo.Good_type;

import java.util.List;
import java.util.Map;

public interface brandImpl {
    List<GoodBrand> findAll();
    GoodBrand findById(int id);
    String addbrand(GoodBrand goodBrand);
    String updatebrand(GoodBrand goodBrand);
    String deleteId(int id);

    Resulet01<GoodBrand> search(int start, int size, String title);
}
