package com.example.goods.Service.Impl;

import com.example.goods.pojo.Good_detali;
import com.example.goods.pojo.Gooddetaliname;

import java.util.List;

public interface GoodsDetaNameImpl {
    List<Gooddetaliname> findAll();
    Gooddetaliname findById(int id);
    String add(Gooddetaliname gooddetaliname);
    String update(Gooddetaliname gooddetaliname);
    String deleteId(int id);
}
