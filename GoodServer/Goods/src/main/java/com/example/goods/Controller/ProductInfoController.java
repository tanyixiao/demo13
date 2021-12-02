package com.example.goods.Controller;

import com.example.goods.Service.ProductInfoServiceImpl;
import com.example.goods.common.Resulet04;
import com.example.goods.pojo.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ProductInfo")
public class ProductInfoController {
    @Autowired
    private ProductInfoServiceImpl productInfoService;
    @RequestMapping("/page")
    public @ResponseBody
    Resulet04<ProductInfo> page(@RequestParam(value = "id",defaultValue = "") String id, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "50") int size){
        return productInfoService.page(id,start,size);
    }
    @RequestMapping("/add")
    public @ResponseBody int add(@RequestBody List<ProductInfo> productInfos){
        return productInfoService.add(productInfos);
    }
    @RequestMapping("/update")
    public @ResponseBody int update(@RequestParam(value = "id",defaultValue = "1") int id,@RequestBody ProductInfo productInfos){
        return productInfoService.update(id,productInfos);
    }
    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestParam(value = "id",defaultValue = "1") int id){
        return productInfoService.delete(id);
    }
}
