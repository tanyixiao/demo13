package com.example.goods.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class UserController {
    @RequestMapping("/login")
    public Map login(@RequestBody Map map){
        Map<String, Object> maps = new HashMap<>();
        Map<String, Object> maps1 = new HashMap<>();
        String username = (String) map.get("username");
        Integer password = Integer.valueOf((String) map.get("password"));
        System.out.println("账号：" + username);
        System.out.println("密码：" + password);
        maps.put("code",20000);
        maps1.put("token","admin-token");
        maps.put("data",maps1);
        return maps;
    }
    @RequestMapping("/info")
    public Map info(){
        Map<String, Object> maps1 = new HashMap<>();
        Map<String, Object> maps = new HashMap<>();
        maps1.put("code",20000);
        maps.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        maps.put("introduction","I am a super administrator");
        maps.put("name","admin");
        ArrayList<String> list = new ArrayList<>();
        list.add("admin");
        maps.put("roles",list);
        maps1.put("data",maps);
        return maps1;
    }
}
