package com.example.goods.Controller;

import com.example.goods.Service.BrandInfoServiceImpl;
import com.example.goods.common.Resulet04;
import com.example.goods.pojo.BrandInfo;
import com.example.goods.pojo.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/BrandInfo")
public class BrandInfoController {
    @Autowired
    private BrandInfoServiceImpl brandInfoService;
    @RequestMapping("/page")
    public @ResponseBody
    Resulet04<BrandInfo> page(@RequestParam(value = "id",defaultValue = "") String id, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "50") int size){
        return brandInfoService.page(id,start,size);
    }
    @RequestMapping("/add")
    public @ResponseBody int add(@RequestBody List<BrandInfo> brandInfos){
        return brandInfoService.add(brandInfos);
    }
    @RequestMapping("/update")
    public @ResponseBody int update(@RequestParam(value = "id",defaultValue = "1") int id,@RequestBody BrandInfo brandInfos){
        return brandInfoService.update(id,brandInfos);
    }
    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestParam(value = "id",defaultValue = "1") int id){
        return brandInfoService.delete(id);
    }
}
