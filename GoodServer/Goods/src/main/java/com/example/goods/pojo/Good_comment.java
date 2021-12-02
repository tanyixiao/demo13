package com.example.goods.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@TableName(value = "good_comment",autoResultMap = true)
public class Good_comment implements Serializable {
    @TableField(exist = false)
    private Goods goods;
    @TableField(exist = false)
    private List<Good_comment> goodCommentList;
    @TableId(value = "good_c_id",type = IdType.AUTO)
    private int good_c_id;
    private String good_c_name;
    private String good_c_email;
    private String good_c_content;
    @TableField(value = "good_Avatar")
    private String good_Avatar;
    private int goods_id;
    private int parent_id;
    @TableField(value = "score")
    private int score;
    @TableField(value = "admins")
    private int admins;
    @TableField(typeHandler = JacksonTypeHandler.class,value = "comment_img")
    private List<String> img;
    @TableField(value = "createtime",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "updatetime",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
