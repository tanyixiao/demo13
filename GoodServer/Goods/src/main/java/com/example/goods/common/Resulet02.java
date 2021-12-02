package com.example.goods.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Resulet02<T,K,V,S,E> {
    int code;
    int count;
    List<Integer> integerList;
    List<T> tList;
    List<K> kList;
    List<V> vList;
    List<S> sList;
    List<E> eList;
}
