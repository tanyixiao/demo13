package com.example.goods.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Resulet01<T> {
    private int code;
    private String msg;
    private List<T> tList;
    private T tObj;
    private Integer count;
}
