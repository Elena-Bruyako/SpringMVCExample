package com.bruyako;

import com.bruyako.entity.Goods;

import java.util.List;

/**
 * Created by brunyatko on 03.02.16.
 */
public interface GoodsDao extends AbstractDao<Goods, Integer>{

    List<Goods> getAll();
    List<Goods> getByFilter(int priceFrom, int priceTo, String name);
}
