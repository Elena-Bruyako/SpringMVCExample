package com.bruyako;

import com.bruyako.model.GoodDto;

import java.util.Collection;

/**
 * Created by brunyatko on 03.02.16.
 */
public interface MarketService {

    Collection<GoodDto> getAll();
}
