package com.example.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@TableName(value = "goods_goodsdetailname",autoResultMap = true)
public class Gooddetaliname implements Serializable {
    @TableId(value = "data_id",type = IdType.AUTO)
    private int id;
    @TableField(value = "gdname")
    private String gdName;
    @TableField(value = "gdvalue")
    private String gdValue;
}
