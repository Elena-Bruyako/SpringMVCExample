package com.bruyako;

import com.bruyako.model.GoodDto;

import java.util.List;

/**
 * Created by brunyatko on 03.02.16.
 */
public interface GoodDao extends AbstractDao<GoodDto, Integer>{

    List<GoodDto> getAll();
}
