package com.example.goods.Controller;

import com.example.goods.Service.CustomerAddrServiceImpl;
import com.example.goods.Service.OrderMasterServiceImpl;
import com.example.goods.common.Resulet04;
import com.example.goods.pojo.CustomerAddr;
import com.example.goods.pojo.OrderMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addr")
public class CustomerAddrController {
    @Autowired
    private CustomerAddrServiceImpl addrService;
    @RequestMapping("/page")
    public @ResponseBody
    Resulet04<CustomerAddr> page(@RequestParam(value = "id",defaultValue = "") String id,@RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "50") int size){
        return addrService.page(id,start,size);
    }
    @RequestMapping("/add")
    public @ResponseBody int add(@RequestBody CustomerAddr customerAddr){
        return addrService.add(customerAddr);
    }
    @RequestMapping("/update")
    public @ResponseBody int update(@RequestParam(value = "id",defaultValue = "1") int id,@RequestBody CustomerAddr customerAddr){
        return addrService.update(id,customerAddr);
    }
    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestParam(value = "id",defaultValue = "1") int id){
        return addrService.delete(id);
    }
}
