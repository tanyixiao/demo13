package com.example.goods.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
@TableName(value = "goods",autoResultMap = true,keepGlobalPrefix = true)
public class Goods implements Serializable {
    @TableId(value = "good_id",type = IdType.AUTO)
    private int good_id;
    private String good_name;
    private Double good_price;
    private String good_account;
    private Double good_sale_price;
    private Boolean good_not;
    private Boolean newproducts;
    private Boolean goodonshelf;
    private Integer good_type_id01;
    private Integer good_type_id02;
    private Integer good_type_id03;
    private int goodsid;
    @TableField(value = "saves")
    private Boolean saves;
    @TableField(value = "pageviews")
    private Integer Pageviews;
    @TableField(value = "good_brand_id")
    private int brandID;
    @TableLogic
    private Integer deleted;
    @Version
    private Integer version;
    @TableField(value = "createtime",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "updatetime",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableField(exist = false)
    private GoodBrand goodBrand;
    @TableField(exist = false)
    private List<Good_type> goodTypeList;
    @TableField(exist = false)
    private List<Good_inventory> goodInventoryList;
    @TableField(exist = false)
    private List<Good_detali> detaliList;
    @TableField(exist = false)
    private List<Good_comment> goodCommentList;
}
