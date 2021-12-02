package com.example.goods.Controller;

import com.example.goods.Service.ProductCategoryServiceImpl;
import com.example.goods.Service.ProductInfoServiceImpl;
import com.example.goods.common.Resulet04;
import com.example.goods.pojo.ProductCategory;
import com.example.goods.pojo.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ProductCategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryServiceImpl productCategoryService;
    @RequestMapping("/page")
    public @ResponseBody
    Resulet04<ProductCategory> page(@RequestParam(value = "id",defaultValue = "") String id, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "100") int size){
        return productCategoryService.page(id,start,size);
    }
    @RequestMapping("/add")
    public @ResponseBody int add(@RequestBody List<ProductCategory> productCategories){
        return productCategoryService.add(productCategories);
    }
    @RequestMapping("/update")
    public @ResponseBody int update(@RequestParam(value = "id",defaultValue = "1") int id,@RequestBody ProductCategory productCategories){
        return productCategoryService.update(id,productCategories);
    }
    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestParam(value = "id",defaultValue = "1") int id){
        return productCategoryService.delete(id);
    }
}
