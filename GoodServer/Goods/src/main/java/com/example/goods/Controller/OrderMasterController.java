package com.example.goods.Controller;

import com.example.goods.Service.OrderCartServiceImpl;
import com.example.goods.Service.OrderMasterServiceImpl;
import com.example.goods.common.Resulet04;
import com.example.goods.pojo.OrderCart;
import com.example.goods.pojo.OrderMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ordermaster")
public class OrderMasterController {
    @Autowired
    private OrderMasterServiceImpl orderMasterService;
    @RequestMapping("/page")
    public @ResponseBody Resulet04<OrderMaster> page(@RequestParam(value = "id",defaultValue = "") String id,@RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "50") int size){
        return orderMasterService.page(id,start,size);
    }
    @RequestMapping("/add")
    public @ResponseBody int add(@RequestBody List<OrderMaster> orderMaster){
        return orderMasterService.add(orderMaster);
    }
    @RequestMapping("/update")
    public @ResponseBody int update(@RequestParam(value = "id",defaultValue = "1") int id,@RequestBody OrderMaster orderMaster){
        return orderMasterService.update(id,orderMaster);
    }
    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestParam(value = "id",defaultValue = "1") int id){
        return orderMasterService.delete(id);
    }
}
