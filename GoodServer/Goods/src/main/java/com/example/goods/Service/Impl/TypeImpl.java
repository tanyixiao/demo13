package com.example.goods.Service.Impl;



import com.example.goods.common.Resulet01;
import com.example.goods.common.Resulet03;
import com.example.goods.pojo.Good_type;

import java.util.List;
import java.util.Map;

public interface TypeImpl {
    List<Good_type> findAll();
    Resulet01<Good_type> Page(int start,int size);
    Resulet01<Good_type> Onelevel(int id);
    Good_type findById(int id);
    String addType(Good_type goodType);
    String deleteId(int id);

    List<Good_type> Levels(Integer id);
}
