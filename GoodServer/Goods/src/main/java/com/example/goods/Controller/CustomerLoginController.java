package com.example.goods.Controller;

import com.example.goods.Service.CustomerLoginServiceImpl;
import com.example.goods.pojo.CustomerLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class CustomerLoginController {
    @Autowired
    private CustomerLoginServiceImpl customerLoginService;
    /**
     * @date 2021/01/10
     * @return 1
     * */
    @RequestMapping("")
    public  @ResponseBody CustomerLogin user(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession Session){
        CustomerLogin customerLogin = customerLoginService.selectByName(username, password);
        Session.setAttribute("user",customerLogin);
        return customerLogin;
    };
    @RequestMapping("loginOut")
    public  @ResponseBody int loginout(){
        return 1;
    };

}
