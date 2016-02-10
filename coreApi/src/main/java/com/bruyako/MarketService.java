package com.bruyako;

import com.bruyako.model.GoodsDto;

import java.util.List;

/**
 * Created by brunyatko on 03.02.16.
 */
public interface MarketService {

    List<GoodsDto> getAll();
    List<GoodsDto> getByFilter(int priceFrom, int priceTo, String name);
    void create(GoodsDto goodsDto);
    void update(GoodsDto goodsDto);
    void deleteById(Long id);
}
