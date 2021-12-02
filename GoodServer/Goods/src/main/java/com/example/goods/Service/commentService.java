package com.example.goods.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.goods.Dao.commentDao;
import com.example.goods.Dao.goodsDao;
import com.example.goods.Dao.sizeDao;
import com.example.goods.Service.Impl.SizeImpl;
import com.example.goods.Service.Impl.commentImpl;
import com.example.goods.common.Resulet01;
import com.example.goods.pojo.Good_comment;
import com.example.goods.pojo.Good_size;
import com.example.goods.pojo.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.PackedColorModel;
import java.util.List;

@Slf4j
@Service
public class commentService implements commentImpl {
    @Autowired
    private commentDao commentDao;
    @Autowired
    private goodsDao goodsDao;
    @Override
    public List<Good_comment> findAll() {
        return null;
    }

    @Override
    public Resulet01<Good_comment> page(int start, int size,String title) {
        Page<Good_comment> page = new Page<>(start,size);
        QueryWrapper<Good_comment> wrapper = new QueryWrapper<>();
        if (title!=""){
            wrapper.like("good_c_name",title);
        }
        wrapper.orderByDesc("createtime").eq("parent_id",0);
        Page<Good_comment> commentPage = commentDao.selectPage(page, wrapper);
        List<Good_comment> commentList = commentPage.getRecords();
        wrapper.clear();
        commentList.forEach(c->{
            Goods goods = goodsDao.selectById(c.getGoods_id());
            c.setGoods(goods);
            List<Good_comment> commentList1 = commentDao.selectList(wrapper.eq("parent_id", c.getGood_c_id()));
            wrapper.clear();
            commentList1.forEach(c1->{
                Goods goods1 = goodsDao.selectById(c1.getGoods_id());
                c1.setGoods(goods1);
                List<Good_comment> commentList2 = commentDao.selectList(wrapper.eq("parent_id", c1.getGood_c_id()));
                commentList2.forEach(c2->{
                    Goods goods2 = goodsDao.selectById(c2.getGoods_id());
                    c2.setGoods(goods2);
                });
                wrapper.clear();
                c1.setGoodCommentList(commentList2);
            });
            c.setGoodCommentList(commentList1);
        });
        Long total = commentPage.getTotal();
        Resulet01<Good_comment> resulet01 = new Resulet01<>();
        return resulet01.setCode(200).setCount(total.intValue()).setTList(commentList);
    }

    @Override
    public Good_comment findById(int id) {
        return null;
    }

    @Override
    public String add(Good_comment goodComment) {
        return null;
    }

    @Override
    public String update(Good_comment goodComment) {
        return null;
    }

    @Override
    public String deleteId(int id) {
        return null;
    }
}
