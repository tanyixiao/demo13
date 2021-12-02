package com.example.goods.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.goods.Dao.BrandDao;
import com.example.goods.Service.Impl.brandImpl;
import com.example.goods.common.Resulet01;
import com.example.goods.pojo.GoodBrand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class brandServer implements brandImpl {
    @Autowired
    private BrandDao brandDao;

    @Override
    public Resulet01<GoodBrand> search(int start, int size, String title) {
        Page<GoodBrand> page = new Page<>(start, size);
        Resulet01<GoodBrand> resulet01 = new Resulet01<>();
        QueryWrapper<GoodBrand> wrapper = new QueryWrapper<>();
        if (!title.equals("")) {
            wrapper.like("good_b_name",title);
        }
        wrapper.orderByDesc("updatetime");
        Page<GoodBrand> goodBrandPage = brandDao.selectPage(page, wrapper);
        List<GoodBrand> brandList = goodBrandPage.getRecords();
        Long total = goodBrandPage.getTotal();
        Integer count=total.intValue();
        return !brandList.isEmpty()?resulet01.setCode(200).setMsg("查询成功").setCount(count).setTList(brandList):resulet01.setCode(400);
    }

    @Override
    public List<GoodBrand> findAll() {
        return brandDao.selectList(null);
    }

    @Override
    public GoodBrand findById(int id) {
        return brandDao.selectById(id);
    }
    @Transactional
    @Override
    public String addbrand(GoodBrand brand) {
        if (brand.getImg().isEmpty()){
            return "400";
        }
        int insert = brandDao.insert(brand);
        return insert!=0?"200":"400";
    }
    @Transactional
    @Override
    public String updatebrand(GoodBrand brand) {
        int update = brandDao.updateById(brand);
        return update!=0?"200":"400";
    }
    @Transactional
    @Override
    public String deleteId(int id) {
        int delete = brandDao.deleteById(id);
        return delete!=0?"200":"400";
    }
}
