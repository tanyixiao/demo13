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
@TableName(value = "good_type",autoResultMap = true)
public class Good_type implements Serializable {
    @TableField(exist = false)
    private List<Good_type> good_type;
    @TableId("good_t_id")
    private int good_t_id;
    private String good_t_name;
    private int parent_id;
    @TableField(value = "category_level")
    private Integer levels;
    @TableField(value = "type_desc")
    private String desc;
    @TableField(typeHandler = JacksonTypeHandler.class,value = "image")
    private List<String> img;
    @TableField(value = "updatetime",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
