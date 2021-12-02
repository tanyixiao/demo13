package com.example.goods.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Resulet04<T> {
    private int code;
    private String msg;
    private List<T> tList;
    private T tObj;
    private Long count;
}
