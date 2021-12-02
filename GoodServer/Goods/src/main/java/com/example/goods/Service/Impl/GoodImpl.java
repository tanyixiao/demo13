package com.example.goods.Service.Impl;

import com.example.goods.common.Resulet01;
import com.example.goods.pojo.Goods;

import java.util.Map;

public interface GoodImpl {

    String addGoods(Map map);

    Goods Edit(int id);

    String update(Map map);

    String delete(int id);

    Resulet01<Goods> index(int start, int size, String title);

    String save(int id, Boolean num);

    Map Count();
}
