package com.example.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

@SpringBootApplication
//有class就是类， 这是一个GoodsApplication类
public class GoodsApplication {

    //public修饰名 static静态的 void返回值类型 main方法名(String[]参数类型 args参数名){}
    public static void main(String[] args) {
       SpringApplication.run(GoodsApplication.class, args);

    }
    //void无返回值
    private void i(){
        System.out.println("我是i（）方法");
    }
    // 返回一个类
    private  GoodsApplication i1(){
        return new GoodsApplication(); //return 返回
    }
    // 返回一个数字
    private int i2(){
        return 0;
    }
    //返回一个字符串
    private String i3()
    {
        return "Heyllo,word";  //
    }
}
