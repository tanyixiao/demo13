package com.example.goods.pojo;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@Accessors(chain = true)
@TableName(value = "user",autoResultMap = true)
public class User implements Serializable {
    @TableId(value = "user_ids",type = IdType.AUTO)
    private int users_id;
    private String username;
    @TableField(value = "passwords")
    private String password;
    private String email;
    private Boolean power;
    @TableField(value = "createtime",fill = FieldFill.INSERT)
    private LocalDate createTime;
    @TableField(value = "updatetime",fill = FieldFill.INSERT_UPDATE)
    private LocalDate updateTime;
    @TableLogic
    private Integer deleted;
    @Version
    private Integer version;
}
