package com.bruyako;

import com.bruyako.model.GoodsDto;
import com.bruyako.model.GoodsFilter;

import java.util.List;

/**
 * Created by brunyatko on 03.02.16.
 */
public interface GoodsDao extends AbstractDao<GoodsDto, Integer>{

    List<GoodsDto> getAll();
    List<GoodsDto> getByFilter(GoodsFilter goodsFilter);
    List<GoodsDto> getByName(String name);
}
