package com.example.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName(value = "good_color",autoResultMap = true)
public class Good_color {
    @TableId(value = "color_id",type = IdType.AUTO)
    private int color_id;
    private String color_name;
    @TableField(value = "color_url_img")
    private String colorUrlImg;
}
