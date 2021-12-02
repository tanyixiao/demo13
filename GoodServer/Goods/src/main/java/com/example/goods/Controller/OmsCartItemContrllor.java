package com.example.goods.Controller;

import com.example.goods.Service.OrderCartServiceImpl;
import com.example.goods.common.Resulet04;

import com.example.goods.pojo.OrderCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/card")
public class OmsCartItemContrllor {
    @Autowired
    private OrderCartServiceImpl orderCartService;
    @RequestMapping("/page")
    public @ResponseBody Resulet04<OrderCart> page(@RequestParam(value = "id",defaultValue = "0") String id, @RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "100") int size){
        return orderCartService.page(id,start,size);
    }
    @RequestMapping("/add")
    public @ResponseBody int add(@RequestBody OrderCart orderCart){
        return orderCartService.add(orderCart);
    }
    @RequestMapping("/update")
    public @ResponseBody int update(@RequestParam(value = "id",defaultValue = "1") int id,@RequestBody OrderCart orderCart){
        return orderCartService.update(id,orderCart);
    }
    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestParam(value = "id",defaultValue = "1") int id){
        return orderCartService.delete(id);
    }
}
