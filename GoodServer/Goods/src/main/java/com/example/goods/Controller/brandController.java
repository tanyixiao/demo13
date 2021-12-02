package com.example.goods.Controller;

import com.example.goods.Service.brandServer;
import com.example.goods.common.Resulet01;
import com.example.goods.pojo.GoodBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/brand")
public class brandController {
    @Autowired
    private brandServer brandServer;
    @RequestMapping("all")
    public @ResponseBody List<GoodBrand> allBrand(){
        return brandServer.findAll();
    }
    @RequestMapping("add")
    public @ResponseBody String addBrand(@RequestBody GoodBrand brand){
        return brandServer.addbrand(brand);
    }
    @RequestMapping("updata")
    public @ResponseBody String updataBrand(@RequestBody GoodBrand brand){
        System.out.println("brand = " + brand);
        return brandServer.updatebrand(brand);
    }
    @RequestMapping("search")
    public @ResponseBody Resulet01<GoodBrand> addBrand(@RequestParam(value = "start",defaultValue = "1") int start, @RequestParam(value = "size",defaultValue = "5") int size
            , @RequestParam(value = "title",defaultValue = "") String title){
        return brandServer.search(start,size,title);
    }
    @RequestMapping("Edit")
    public @ResponseBody GoodBrand addBrand(@RequestParam(value = "id",defaultValue = "1") int id){
        return brandServer.findById(id);
    }
    @RequestMapping("delete")
    public @ResponseBody String deleteBrand(@RequestParam(value = "id",defaultValue = "1") int id){
        return brandServer.deleteId(id);
    }
}
