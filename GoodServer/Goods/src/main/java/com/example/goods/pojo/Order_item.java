package com.example.goods.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order_item implements Serializable {
    private int order_id;
    private String order_color;
    private String order_size;
    private int order_count;
}
