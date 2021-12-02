package com.example.goods.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class good03Resulet <G,S,C>{
    private List<G> goodsList;
    private List<C> goodColorList;
    private List<S> sizeList;
}
