package com.example.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@TableName(value = "good_size",autoResultMap = true)
public class Good_size implements Serializable {
    @TableId(value = "size_id" ,type = IdType.AUTO)
    private int size_id;
    private String size_name;
}
