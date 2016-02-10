package com.bruyako;

import com.bruyako.model.GoodsDto;

import java.util.List;

/**
 * Created by brunyatko on 03.02.16.
 */
public interface MarketService {

    List<GoodsDto> getAll();
    List<GoodsDto> getByFilter(int priceFrom, int priceTo, String name);
    public void create(GoodsDto goodsDto);
    public void update(GoodsDto goodsDto);
    public void deleteById(Integer id);
}
