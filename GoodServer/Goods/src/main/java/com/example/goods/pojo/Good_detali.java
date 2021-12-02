package com.example.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
@TableName(value = "goods_goodsdetail",autoResultMap = true)
public class Good_detali implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> gdurl;
    private int goods_id;
    private int gdname_id;
    @TableField(exist = false)
    private List<Gooddetaliname> gooddetalinameList;
}
