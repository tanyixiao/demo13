package com.example.goods.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Goods02Resulet<T,V> {
    private T tObj;
    private V vObj;
}
