package com.example.goods.Service;

import com.example.goods.Dao.inventoryDao;
import com.example.goods.Service.Impl.InventoryImpl;
import com.example.goods.pojo.Good_inventory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class InventoryService implements InventoryImpl {
    @Autowired
    private inventoryDao inventoryDao;
    @Override
    public List<Good_inventory> findAll() {
        return null;
    }

    @Override
    public Good_inventory findById(int id) {
        return null;
    }

    @Override
    public String add(Good_inventory goodInventoryi) {
        int insert = inventoryDao.insert(goodInventoryi);
        return insert!=0?"200":"400";
    }

    @Override
    public String update(Good_inventory goodInventory) {
        return null;
    }

    @Override
    public String deleteId(int id) {
        return null;
    }
}
