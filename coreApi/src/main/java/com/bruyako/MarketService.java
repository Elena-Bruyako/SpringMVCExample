package com.bruyako;

import com.bruyako.model.GoodsDto;
import com.bruyako.model.GoodsFilter;

import java.util.List;

/**
 * Created by brunyatko on 03.02.16.
 */
public interface MarketService {

    List<GoodsDto> getAll();
    List<GoodsDto> getByFilter(GoodsFilter goodsFilter);
    public void create(GoodsDto goodsDto);
    public void update(GoodsDto goodsDto);
    public void delete(Integer id);
}
