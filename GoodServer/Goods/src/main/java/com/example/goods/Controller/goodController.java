package com.example.goods.Controller;

import com.example.goods.Service.GoodService;
import com.example.goods.common.Resulet01;
import com.example.goods.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/good")
public class goodController {
    @Autowired
    private GoodService goodService;
    @RequestMapping("")
    public @ResponseBody Map index01(){
        return goodService.Count();
    }
    @RequestMapping("add")
    public @ResponseBody String addGoods(@RequestBody Map map){
        return goodService.addGoods(map);
    }
    @RequestMapping("edit")
    public @ResponseBody Goods editGoods(@RequestParam("id") int id){
        return goodService.Edit(id);
    }
    @RequestMapping("update")
    public @ResponseBody String update(@RequestBody Map map){
        return goodService.update(map);
    }
    @RequestMapping("delete")
    public @ResponseBody String delete(@RequestParam("id") int id){
        return goodService.delete(id);
    }
    @RequestMapping("index")
    public @ResponseBody Resulet01<Goods> index(@RequestParam(value = "start",defaultValue = "1") int start,@RequestParam(value = "size",defaultValue = "5") int size
    ,@RequestParam(value = "title",defaultValue = "") String title){
        return goodService.index(start,size,title);
    }
    @RequestMapping("save")
    public @ResponseBody String index(@RequestParam(value = "id",defaultValue = "1") int id,@RequestParam(value = "num",defaultValue = "false") Boolean num){
        return goodService.save(id,num);
    }

}
