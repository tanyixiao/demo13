package com.example.goods.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goods.common.Resulet04;
import com.example.goods.pojo.BrandInfo;
import com.example.goods.Service.Impl.BrandInfoService;
import com.example.goods.Dao.BrandInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author xiao
* @description 针对表【brand_info(品牌信息表)】的数据库操作Service实现
* @createDate 2021-12-01 10:06:04
*/
@Service
public class BrandInfoServiceImpl implements BrandInfoService{
    @Autowired
    private BrandInfoMapper brandInfoMapper;
    @Override
    public Resulet04<BrandInfo> page(String id, int start, int size) {
        List<BrandInfo> page = brandInfoMapper.page(id, start, size);
        Long count = brandInfoMapper.Count();
        Resulet04<BrandInfo> resulet04 = new Resulet04<>();
        return resulet04.setCount(count).setTList(page);
    }

    @Override
    public int add(List<BrandInfo> brandInfos) {
        return brandInfoMapper.add(brandInfos);
    }

    @Override
    public int update(int id, BrandInfo brandInfos) {
        return brandInfoMapper.update(id, brandInfos);
    }

    @Override
    public int delete(int id) {
        return brandInfoMapper.delete(id);
    }
}




