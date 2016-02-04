package com.bruyako.impl;

import com.bruyako.GoodsDao;
import com.bruyako.MarketService;
import com.bruyako.model.GoodsDto;
import com.bruyako.model.GoodsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by brunyatko on 03.02.16.
 */
@Transactional
@Service
public class MarketServiceImpl implements MarketService{

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<GoodsDto> getAll() {

        return goodsDao.getAll();
    }

    @Override
    public List<GoodsDto> getByFilter(GoodsFilter goodsFilter) {
        return goodsDao.getByFilter(goodsFilter);
    }
}
