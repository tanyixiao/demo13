package com.example.goods.Service.Impl;

import com.example.goods.common.Resulet01;
import com.example.goods.pojo.Good_comment;
import com.example.goods.pojo.Good_detali;

import java.util.List;

public interface commentImpl {
    List<Good_comment> findAll();
    Resulet01<Good_comment> page(int start ,int size,String title);
    Good_comment findById(int id);
    String add(Good_comment goodComment);
    String update(Good_comment goodComment);
    String deleteId(int id);
}
