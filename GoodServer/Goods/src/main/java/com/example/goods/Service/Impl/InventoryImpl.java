package com.example.goods.Service.Impl;

import com.example.goods.pojo.Good_detali;
import com.example.goods.pojo.Good_inventory;
import com.example.goods.pojo.Good_size;

import java.util.List;

public interface InventoryImpl {
    List<Good_inventory> findAll();
    Good_inventory findById(int id);
    String add(Good_inventory goodInventoryi);
    String update(Good_inventory goodInventory);
    String deleteId(int id);
}
