package com.example.goods.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.goods.Dao.*;
import com.example.goods.Service.Impl.GoodImpl;
import com.example.goods.common.Resulet01;
import com.example.goods.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class GoodService implements GoodImpl {
    @Autowired
    private goodsDao goodsDao;
    @Autowired
    private ColorDao colorDao;
    @Autowired
    private GoodsDetaDao goodsDetaDao;
    @Autowired
    private inventoryDao inventoryDao;
    @Autowired
    private sizeDao sizeDao;
    @Autowired
    private GoodsDetaNameDao goodsDetaNameDao;
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private commentDao commentDao;
    @Autowired
    private typeDao typeDao;
    @Autowired
    private UserDao userDao;
    @Override
    public Map Count() {
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        Integer good = goodsDao.selectCount(wrapper);
        Integer comment = commentDao.selectCount(null);
        Integer user = userDao.selectCount(null);
        Integer order = goodsDao.selectCount(null);
        map.put("userCount",user);
        map.put("goodsCount",good);
        map.put("commentCount",comment);
        map.put("OrderCount",order);
        return map;
    }

    @Transactional
    @Override
    public String addGoods(Map map)  {
        String goodName = (String) map.get("good_name");
        Integer brand = (Integer) map.get("brandID");
        String account = (String) map.get("good_account");
        Boolean good_not = (Boolean) map.get("good_not");
        Double good_price = Double.valueOf((String) map.get("good_price"));
        Double good_sale_price = Double.valueOf((String) map.get("good_sale_price"));
        List<Integer> good_type_id = (List<Integer>) map.get("good_type_id01");
        Boolean goodOnShelf = (Boolean) map.get("goodonshelf");
        Boolean newProducts = (Boolean) map.get("newproducts");
        Integer goodsId = Integer.valueOf((String) map.get("goodsid"));
        Goods goods = new Goods();
        goods.setGood_name(goodName).setGood_not(good_not).setGood_account(account).setGood_price(good_price).setGood_sale_price(good_sale_price).
                setGood_type_id01(good_type_id.get(0)).setGoodonshelf(goodOnShelf).setNewproducts(newProducts).setBrandID(brand).setGoodsid(goodsId);
        switch (good_type_id.size()){
            case 1:
                goods.setGood_type_id02(1);
                break;
            case 2:
                goods.setGood_type_id02(1).setGood_type_id03(2);
                break;
        }
        int insertGoods = goodsDao.insert(goods);
        List<Map> specsDatali = (List<Map>) map.get("specsDatali01");
        Good_color color = new Good_color();
        Good_size size = new Good_size();
        Good_inventory inventory = new Good_inventory();
        specsDatali.forEach(m->{
            String colorText = (String) m.get("colorText");
            String colorUrl = (String) m.get("colorUrl");
            Integer count = Integer.valueOf((String) m.get("count"));
            String sizeText = (String) m.get("sizeText");
            color.setColor_name(colorText).setColorUrlImg(colorUrl);
            size.setSize_name(sizeText);
            colorDao.insert(color);
            sizeDao.insert(size);
            inventory.setGood_count(count).setGoods_id(goods.getGood_id()).setColors_id(color.getColor_id()).setSizes_id(size.getSize_id());
            inventoryDao.insert(inventory);
        });
        Good_detali goodDetali = new Good_detali();
        Gooddetaliname gooddetaliname = new Gooddetaliname();
        List<Map> specsDatali02 = (List<Map>) map.get("specsDatali02");
        specsDatali02.forEach(map1 -> {
            String detailAccount = (String) map.get("detailAccount");
            List<String> imgList = img(detailAccount);
            String paramName = (String) map1.get("paramName");
            String paramValues = (String) map1.get("paramValues");
            gooddetaliname.setGdName(paramName).setGdValue(paramValues);
            goodsDetaNameDao.insert(gooddetaliname);
            goodDetali.setGoods_id(goods.getGood_id()).setGdname_id(gooddetaliname.getId()).setGdurl(imgList);
            goodsDetaDao.insert(goodDetali);
        });
        return insertGoods!=0?"200":"400";
    }
    public static List<String> img(String content){
        List<String> list = new ArrayList<String>();
            Pattern pattern = Pattern.compile("<(img|IMG)(.*?)(/>|></img>|>)");
            Matcher matcher = pattern.matcher(content);
            boolean b = matcher.find();
            if (b) {
                while (b) {
                    //获取到匹配的<img />标签中的内容
                    String str_img = matcher.group(2);

                    //开始匹配<img />标签中的src
                    Pattern p_src = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");
                    Matcher m_src = p_src.matcher(str_img);
                    if (m_src.find()) {
                        String str_src = m_src.group(3);
                        list.add(str_src);
                    }
                    //结束匹配<img />标签中的src

                    //匹配content中是否存在下一个<img />标签，有则继续以上步骤匹配<img />标签中的src
                    b = matcher.find();
                }
            }
        return list;
    }

    @Override
    public Goods Edit(int id) {
        Goods goods = goodsDao.selectById(id);
        QueryWrapper<Good_type> goodTypeQueryWrapper = new QueryWrapper<>();
        GoodBrand goodBrand = brandDao.selectById(goods.getBrandID());
        goods.setGoodBrand(goodBrand);
        goodTypeQueryWrapper.eq("good_t_id",goods.getGood_type_id01());
        List<Good_type> goodTypeList = typeDao.selectList(goodTypeQueryWrapper);
        goodTypeQueryWrapper.clear();
        goodTypeList.forEach(t->{
            goodTypeQueryWrapper.eq("good_t_id",goods.getGood_type_id02());
            List<Good_type> typeList = typeDao.selectList(goodTypeQueryWrapper);
            goodTypeQueryWrapper.clear();
            typeList.forEach(t1->{
                goodTypeQueryWrapper.eq("good_t_id",goods.getGood_type_id03());
                t1.setGood_type(typeDao.selectList(goodTypeQueryWrapper));
                goodTypeQueryWrapper.clear();
            });
            t.setGood_type(typeList);
        });
        goods.setGoodTypeList(goodTypeList);
        QueryWrapper<Good_inventory> inventoryQueryWrapper = new QueryWrapper<>();
        List<Good_inventory> inventory = inventoryDao.selectList(inventoryQueryWrapper.eq("goods_id",id));
        QueryWrapper<Good_color> colorQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Good_size> SizeQueryWrapper = new QueryWrapper<>();
        inventoryQueryWrapper.clear();
        inventory.forEach(i->{
            SizeQueryWrapper.eq("size_id",i.getSizes_id());
            List<Good_size> sizeList = sizeDao.selectList(SizeQueryWrapper);
            colorQueryWrapper.eq("color_id",i.getColors_id());
            List<Good_color> colorList = colorDao.selectList(colorQueryWrapper);
            SizeQueryWrapper.clear();
            colorQueryWrapper.clear();
            i.setGoodSizeList(sizeList).setColorList(colorList).setGood_count(i.getGood_count());
        });
        goods.setGoodInventoryList(inventory);
        QueryWrapper<Good_detali> goodDetaliQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Gooddetaliname> gooddetalinameQueryWrapper = new QueryWrapper<>();
        goodDetaliQueryWrapper.eq("goods_id", id);
        List<Good_detali> detaliList = goodsDetaDao.selectList(goodDetaliQueryWrapper);
        goodDetaliQueryWrapper.clear();
        detaliList.forEach(t->{
            gooddetalinameQueryWrapper.eq("data_id", t.getGdname_id());
            List<Gooddetaliname> gooddetalinameList = goodsDetaNameDao.selectList(gooddetalinameQueryWrapper);
            gooddetalinameQueryWrapper.clear();
            t.setGooddetalinameList(gooddetalinameList);
        });
        goods.setDetaliList(detaliList);
//        QueryWrapper<Good_comment> goodCommentQueryWrapper = new QueryWrapper<>();
//        goodCommentQueryWrapper.eq("goods_id",id);
//        List<Good_comment> commentList = commentDao.selectList(goodCommentQueryWrapper);
//        goodCommentQueryWrapper.clear();
//        commentList.forEach(c->{
//            Goods goods1 = goodsDao.selectById(c.getGoods_id());
//            c.setGoods(goods1);
//            List<Good_comment> commentList1 = commentDao.selectList(goodCommentQueryWrapper.eq("parent_id", c.getGood_c_id()));
//            goodCommentQueryWrapper.clear();
//            commentList1.forEach(c1->{
//                Goods goods2 = goodsDao.selectById(c1.getGoods_id());
//                c1.setGoods(goods2);
//                List<Good_comment> commentList2 = commentDao.selectList(goodCommentQueryWrapper.eq("parent_id", c1.getGood_c_id()));
//                commentList2.forEach(c2->{
//                    Goods goods3 = goodsDao.selectById(c2.getGoods_id());
//                    c2.setGoods(goods3);
//                });
//                goodCommentQueryWrapper.clear();
//                c1.setGoodCommentList(commentList2);
//            });
//            c.setGoodCommentList(commentList1);
//        });
//        goods.setGoodCommentList(commentList);
        return goods;
    }
    @Transactional
    @Override
    public String update(Map map) {
        Integer good_id = (Integer) map.get("good_id");
        Goods goods1 = goodsDao.selectById(good_id);
        String goodName = (String) map.get("good_name");
        Integer brand = (Integer) map.get("brandID");
        String account = (String) map.get("good_account");
        Boolean good_not = (Boolean) map.get("good_not");
        Double good_price =Double.valueOf((Integer) map.get("good_price"));
        Double good_sale_price = Double.valueOf((Integer) map.get("good_sale_price"));
        List<Integer> good_type_id = (List<Integer>) map.get("good_type_id01");
        Boolean goodOnShelf = (Boolean) map.get("goodonshelf");
        Boolean newProducts = (Boolean) map.get("newproducts");
        Integer goodsId = (Integer) map.get("goodsid");
        Goods goods = new Goods();
        goods.setGoodsid(goodsId).setGood_name(goodName).setGood_not(good_not).setGood_account(account).setGood_price(good_price).setGood_sale_price(good_sale_price)
        .setGood_type_id01(good_type_id.get(0)).setGoodonshelf(goodOnShelf).setNewproducts(newProducts).setBrandID(brand).setGood_id(good_id).setVersion(goods1.getVersion());
        switch (good_type_id.size()){
            case 1:
                goods.setGood_type_id02(1);
                break;
            case 2:
                goods.setGood_type_id02(1).setGood_type_id03(2);
                break;
        }
        int updateGoods = goodsDao.updateById(goods);
        List<Map> specsDatali = (List<Map>) map.get("specsDatali01");
        Good_color color = new Good_color();
        Good_size size = new Good_size();
        Good_inventory inventory = new Good_inventory();
        QueryWrapper<Good_inventory> wrapper = new QueryWrapper<>();
        wrapper.eq("goods_id",good_id);
        specsDatali.forEach(m->{
            if (!m.get("color_id").equals("")&&!m.get("size_id").equals("")){
                String colorText = (String) m.get("colorText");
                String colorUrl = (String) m.get("colorUrl");
                Integer count = (Integer) m.get("count");
                Integer color_id = (Integer) m.get("color_id");
                Integer size_id = (Integer) m.get("size_id");
                String sizeText = (String) m.get("sizeText");
                color.setColor_name(colorText).setColorUrlImg(colorUrl).setColor_id(color_id);
                size.setSize_name(sizeText).setSize_id(size_id);
                colorDao.updateById(color);
                sizeDao.updateById(size);
                inventory.setGood_count(count).setGoods_id(good_id).setColors_id(color_id).setSizes_id(size_id);
                wrapper.eq("colors_id",color_id).eq("goods_id",good_id).eq("sizes_id",size_id);
                inventoryDao.update(inventory,wrapper);
                wrapper.clear();
            }else {
                String colorText = (String) m.get("colorText");
                String colorUrl = (String) m.get("colorUrl");
                Integer count = Integer.valueOf((String) m.get("count"));
                String sizeText = (String) m.get("sizeText");
                color.setColor_name(colorText).setColorUrlImg(colorUrl);
                size.setSize_name(sizeText);
                colorDao.insert(color);
                sizeDao.insert(size);
                inventory.setGood_count(count).setGoods_id(goods.getGood_id()).setColors_id(color.getColor_id()).setSizes_id(size.getSize_id());
                inventoryDao.insert(inventory);
            }
        });
        Good_detali goodDetali = new Good_detali();
        Gooddetaliname gooddetaliname = new Gooddetaliname();
        List<Map> specsDatali02 = (List<Map>) map.get("specsDatali02");
        QueryWrapper<Good_detali> goodDetaliQueryWrapper = new QueryWrapper<>();
        specsDatali02.forEach(map1 -> {
             map1.get("param_id");
            if (!map1.get("param_id").equals("")){
                String detailAccount = (String) map.get("detailAccount");
                List<String> img = img(detailAccount);
                String paramName = (String) map1.get("paramName");
                String paramValues = (String) map1.get("paramValues");
                Integer paramId = (Integer) map1.get("param_id");
                gooddetaliname.setGdName(paramName).setGdValue(paramValues).setId(paramId);
                goodDetali.setGoods_id(good_id).setGdname_id(paramId).setGdurl(img);
                goodsDetaNameDao.updateById(gooddetaliname);
                goodDetaliQueryWrapper.eq("gdname_id",paramId).eq("goods_id",good_id);
                goodsDetaDao.update(goodDetali,goodDetaliQueryWrapper);
                wrapper.clear();
            }else {
                String detailAccount = (String) map.get("detailAccount");
                List<String> imgList = img(detailAccount);
                String paramName = (String) map1.get("paramName");
                String paramValues = (String) map1.get("paramValues");
                gooddetaliname.setGdName(paramName).setGdValue(paramValues);
                goodsDetaNameDao.insert(gooddetaliname);
                goodDetali.setGoods_id(goods.getGood_id()).setGdname_id(gooddetaliname.getId()).setGdurl(imgList);
                goodsDetaDao.insert(goodDetali);
            }
        });
        return updateGoods!=0?"200":"400";
    }
    @Transactional
    @Override
    public String delete(int id) {
        int deleteById = goodsDao.deleteById(id);
        QueryWrapper<Good_inventory> inventoryQueryWrapper = new QueryWrapper<>();
        inventoryQueryWrapper.eq("goods_id",id);
        int delete = inventoryDao.delete(inventoryQueryWrapper);
        return delete!=0?"200":"400";
    }

    @Override
    public Resulet01<Goods> index(int start, int size, String title) {
        Resulet01<Goods> resulet01 = new Resulet01<>();
        Page<Goods> page = new Page<>(start, size);
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("updatetime");
        if (title!=""){
            wrapper.like("good_name",title);
        }
        Page<Goods> goodsPage = goodsDao.selectPage(page, wrapper);
        Long pageTotal = goodsPage.getTotal();
        int Total = pageTotal.intValue();
        List<Goods> goodsList = goodsPage.getRecords();
        QueryWrapper<Good_inventory> inventoryQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Good_detali> detaliQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Good_type> goodTypeQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Good_size> sizeQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Good_color> colorQueryWrapper = new QueryWrapper<>();
        QueryWrapper<Gooddetaliname> gooddetalinameQueryWrapper = new QueryWrapper<>();
        goodsList.forEach(goods -> {
            GoodBrand goodBrand = brandDao.selectById(goods.getBrandID());
            goods.setGoodBrand(goodBrand);
            goodTypeQueryWrapper.eq("good_t_id",goods.getGood_type_id01());
            List<Good_type> goodTypeList = typeDao.selectList(goodTypeQueryWrapper);
            goodTypeQueryWrapper.clear();
            goodTypeList.forEach(t->{
                goodTypeQueryWrapper.eq("good_t_id",goods.getGood_type_id02());
                List<Good_type> typeList = typeDao.selectList(goodTypeQueryWrapper);
                goodTypeQueryWrapper.clear();
                typeList.forEach(t1->{
                    goodTypeQueryWrapper.eq("good_t_id",goods.getGood_type_id03());
                    t1.setGood_type(typeDao.selectList(goodTypeQueryWrapper));
                    goodTypeQueryWrapper.clear();
                });
                t.setGood_type(typeList);
            });
            goods.setGoodTypeList(goodTypeList);
            inventoryQueryWrapper.eq("goods_id",goods.getGood_id());
            List<Good_inventory> inventoryList = inventoryDao.selectList(inventoryQueryWrapper);
            inventoryQueryWrapper.clear();
            inventoryList.forEach(i->{
                sizeQueryWrapper.eq("size_id",i.getSizes_id());
                List<Good_size> sizeList = sizeDao.selectList(sizeQueryWrapper);
                colorQueryWrapper.eq("color_id",i.getColors_id());
                List<Good_color> goodColorList = colorDao.selectList(colorQueryWrapper);
                i.setGoodSizeList(sizeList).setColorList(goodColorList);
                colorQueryWrapper.clear();
                sizeQueryWrapper.clear();
            });
            goods.setGoodInventoryList(inventoryList);
            detaliQueryWrapper.eq("goods_id",goods.getGood_id());
            List<Good_detali> detaliList = goodsDetaDao.selectList(detaliQueryWrapper);
            detaliQueryWrapper.clear();
            detaliList.forEach(goodDetali -> {
                gooddetalinameQueryWrapper.eq("data_id",goodDetali.getGdname_id());
                List<Gooddetaliname> gooddetalinameList = goodsDetaNameDao.selectList(gooddetalinameQueryWrapper);
                goodDetali.setGooddetalinameList(gooddetalinameList);
                gooddetalinameQueryWrapper.clear();
            });
            goods.setDetaliList(detaliList);
        });
        return !goodsList.isEmpty()?resulet01.setMsg("成功").setCode(200).setCount(Total).setTList(goodsList):resulet01.setCode(400);
    }

    @Override
    public String save(int id, Boolean num) {
        Goods goods = goodsDao.selectById(id);
        goods.setSaves(num).setVersion(goods.getVersion());
        int update = goodsDao.updateById(goods);
        return update!=0?"200":"400";
    }
}

