package com.example.goods.Service.Impl;

import com.example.goods.common.Resulet04;
import com.example.goods.pojo.BrandInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xiao
* @description 针对表【brand_info(品牌信息表)】的数据库操作Service
* @createDate 2021-12-01 10:06:04
*/
public interface BrandInfoService {
    Resulet04<BrandInfo> page(String id, int start, int size);
    int add(List<BrandInfo> brandInfos);
    int update(int id, BrandInfo brandInfos);
    int delete(int id);
}
