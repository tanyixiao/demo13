package com.example.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
@TableName(value = "good_inventory",autoResultMap = true)
public class Good_inventory implements Serializable {
    @TableId(value = "good_i_id",type = IdType.AUTO)
    private int good_i_id;
    @TableField(value = "good_i_count")
    private int good_count;
    private int colors_id;
    private int goods_id;
    private int sizes_id;
    @TableField(exist = false)
    private List<Good_color> colorList;
    @TableField(exist = false)
    private List<Good_size> goodSizeList;

}
