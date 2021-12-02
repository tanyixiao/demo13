package com.example.goods.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
@TableName(value = "good_brand",autoResultMap = true)
public class GoodBrand implements Serializable {
    @TableId(value = "good_b_id")
    private int id;
    @TableField(value = "good_b_name")
    private String goodBrandName;
    @TableField(typeHandler = JacksonTypeHandler.class,value = "img")
    private List<String> img;
    @TableField(value = "brandDesc")
    private String brandDesc;
    @TableField(value = "updatetime",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
