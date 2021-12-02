package com.example.goods.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.goods.Dao.typeDao;
import com.example.goods.Service.Impl.TypeImpl;
import com.example.goods.common.Resulet01;
import com.example.goods.common.Resulet03;
import com.example.goods.pojo.Good_type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TypeService implements TypeImpl {
    @Autowired
    private typeDao typeDao;
    private Resulet01<Good_type> resulet01;

    @Override
    public List<Good_type> findAll() {
        return typeDao.selectList(null);
    }

    @Override
    public Resulet01<Good_type> Page(int start, int size) {
        Page<Good_type> page = new Page<>(start, size);
        QueryWrapper<Good_type> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Good_type::getParent_id,0).orderByDesc(Good_type::getUpdateTime);
        Page<Good_type> page1 = typeDao.selectPage(page, wrapper);
        List<Good_type> typeList = typeDao.selectPage(page,wrapper).getRecords();
        wrapper.clear();
        typeList.forEach(t->{
            wrapper.eq("parent_id",t.getGood_t_id());
            List<Good_type> goodTypeList02 = typeDao.selectList(wrapper);
            wrapper.clear();
            goodTypeList02.forEach(t1->{
                wrapper.eq("parent_id",t1.getGood_t_id());
                List<Good_type> goodTypeList03 = typeDao.selectList(wrapper);
                t1.setGood_type(goodTypeList03);
                wrapper.clear();
            });
            t.setGood_type(goodTypeList02);
        });
        Resulet01<Good_type> resulet01 = new Resulet01<>();
        Long total = page1.getTotal();
        return resulet01.setCode(200).setCount(total.intValue()).setTList(typeList);
    }
    @Override
    public Resulet01<Good_type> Onelevel(int id) {
        Resulet01<Good_type> resulet01 = new Resulet01<>();
        if(id!=0){
            Good_type goodType = typeDao.selectById(id);
            resulet01.setTObj(goodType);
        }
        QueryWrapper<Good_type> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(Good_type::getParent_id,id).orderByDesc(Good_type::getUpdateTime);
            log.info("一级分类查询");
            List<Good_type> typeList1 = typeDao.selectList(wrapper);
            wrapper.clear();
            typeList1.forEach(t->{
                wrapper.eq("parent_id",t.getGood_t_id());
                log.info("二级分类查询");
                List<Good_type> goodTypeList02 = typeDao.selectList(wrapper);
                t.setGood_type(goodTypeList02);
                wrapper.clear();
                goodTypeList02.forEach(t1->{
                    wrapper.eq("parent_id",t1.getGood_t_id());
                    log.info("三级分类查询");
                    List<Good_type> goodTypeList03 = typeDao.selectList(wrapper);
                    t1.setGood_type(goodTypeList03);
                    wrapper.clear();
                });
            });
        return resulet01.setTList(typeList1).setCode(200).setCount(typeList1.size());
    }

    @Override
    public Good_type findById(int id) {
        Good_type good_type = typeDao.selectById(id);
        return null;
    }

    @Override
    public String addType(Good_type goodType) {
        Good_type type = typeDao.selectById(goodType);
        int i=0;
        if (type==null){
            log.info("增加分类");
            while (i==0){
                if (goodType.getParent_id()!=0&&goodType.getGood_type().get(0).getGood_t_id()==0){
                    System.out.println("二级分类");
                    int insert = typeDao.insert(goodType.setLevels(2));
                    i+=1;
                    return insert!=0?"200":"400";
                }else if (goodType.getParent_id()!=0&&goodType.getGood_type().get(0).getGood_t_id()!=0){
                    System.out.println("三级分类");
                    int insert = typeDao.insert(goodType.setLevels(3).setParent_id(goodType.getGood_type().get(0).getGood_t_id()));
                    i+=1;
                    return insert!=0?"200":"400";
                }else if (goodType.getParent_id()==0&&goodType.getGood_type().get(0).getGood_t_id()==0){
                    System.out.println("一级分类");
                    int insert = typeDao.insert(goodType.setLevels(1));
                    i+=1;
                    return insert!=0?"200":"400";
                }
            }
        }else {
            log.info("更新分类");
            goodType.setLevels(type.getLevels());
            int update = typeDao.updateById(goodType);
            return update!=0?"200":"400";
        }
        return "200";
    }

    @Override
    public String deleteId(int id) {
        QueryWrapper<Good_type> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Good_type::getGood_t_id,id);
        int delete = typeDao.delete(wrapper);
        return delete!=0?"200":"400";
    }

    @Override
    public List<Good_type> Levels(Integer id) {
        QueryWrapper<Good_type> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        List<Good_type> typeList = typeDao.selectList(wrapper);
        wrapper.clear();
        return typeList;
    }

}
