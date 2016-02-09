package com.bruyako.impl;

import com.bruyako.GoodsDao;
import com.bruyako.MarketService;
import com.bruyako.model.GoodsDto;
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

    public void setDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public List<GoodsDto> getAll() {

        return goodsDao.getAll();
    }

    @Override
    public List<GoodsDto> getByFilter(int priceFrom, int priceTo, String name) {
        return goodsDao.getByFilter(priceFrom, priceTo, name);
    }

    @Override
    public void create(GoodsDto goodsDto) {
        goodsDao.create(goodsDto);
    }

    @Override
    public void update(GoodsDto goodsDto) {
        goodsDao.update(goodsDto);
    }

    @Override
    public void delete(Integer id) {
        goodsDao.delete(id);
    }


}
