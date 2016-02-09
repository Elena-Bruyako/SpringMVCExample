package com.bruyako;

import com.bruyako.model.GoodsDto;

import java.util.List;

/**
 * Created by brunyatko on 03.02.16.
 */
public interface GoodsDao extends AbstractDao<GoodsDto, Integer>{

    List<GoodsDto> getAll();
    List<GoodsDto> getByFilter(int priceFrom, int priceTo, String name);
}
