package com.example.goods.Controller;

import com.example.goods.Service.TypeService;
import com.example.goods.common.Resulet01;
import com.example.goods.common.Resulet03;
import com.example.goods.pojo.Good_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/type")
public class typeController {
    @Autowired
    private TypeService typeService;
    @RequestMapping("page")
    public @ResponseBody Resulet01<Good_type> page(@RequestParam(value = "start",defaultValue = "1") int start,
                              @RequestParam(value = "size",defaultValue = "5") int size){
        return  typeService.Page(start, size);
    }
    @RequestMapping("Typelevel")
    public @ResponseBody Resulet01<Good_type> Typelevel(@RequestParam(value = "id",defaultValue = "0") int id){
        return  typeService.Onelevel(id);
    }
    @RequestMapping("Edit")
    public @ResponseBody Good_type editType(@RequestParam(value = "id",defaultValue = "1") Integer id){
        return  typeService.findById(id);
    }
    @RequestMapping("typeAll")
    public @ResponseBody List<Good_type> AllType(){
        return  typeService.findAll();
    }
    @RequestMapping("level")
    public @ResponseBody List<Good_type> Levels(@RequestParam(value = "id",defaultValue = "1") Integer id){
        return  typeService.Levels(id);
    }
    @RequestMapping("addType")
    public @ResponseBody String addType(@RequestBody Good_type goodType){
        System.out.println("goodTypes = " + goodType);
        return  typeService.addType(goodType);
    }
    @RequestMapping("delete")
    public @ResponseBody String deleteType(@RequestParam(value = "id",defaultValue = "1") Integer id){

        return  typeService.deleteId(id);
    }


}
