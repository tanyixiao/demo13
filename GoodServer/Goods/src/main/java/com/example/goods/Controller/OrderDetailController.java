package com.example.goods.Controller;

import com.example.goods.Service.OrderDetailServiceImpl;
import com.example.goods.Service.OrderMasterServiceImpl;
import com.example.goods.common.Resulet04;
import com.example.goods.pojo.OrderDetail;
import com.example.goods.pojo.OrderMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailServiceImpl orderDetailService;
    @RequestMapping("/page")
    public @ResponseBody Resulet04<OrderDetail> page(@RequestParam(value = "id",defaultValue = "") String id, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "100") int size){
        return orderDetailService.page(id,start,size);
    }
    @RequestMapping("/add")
    public @ResponseBody int add(@RequestBody List<OrderDetail> orderDetails){
        return orderDetailService.add(orderDetails);
    }
    @RequestMapping("/update")
    public @ResponseBody int update(@RequestParam(value = "id",defaultValue = "") String id,@RequestBody OrderDetail orderDetail){
        return orderDetailService.update(id,orderDetail);
    }
    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestParam(value = "id",defaultValue = "1") int id){
        return orderDetailService.delete(id);
    }
}
