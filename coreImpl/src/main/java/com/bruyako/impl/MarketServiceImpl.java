package com.bruyako.impl;

import com.bruyako.GoodsDao;
import com.bruyako.MarketService;
import com.bruyako.converter.EntityDtoConverter;
import com.bruyako.entity.Goods;
import com.bruyako.model.GoodsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

        List<Goods> list = goodsDao.getAll();
        List<GoodsDto> result = new ArrayList<>(list.size());
        for (Goods goods : list) {
            result.add(EntityDtoConverter.convert(goods));
        }
        return result;
    }

    @Override
    public List<GoodsDto> getByFilter(int priceFrom, int priceTo, String name) {

        List<Goods> list = goodsDao.getByFilter(priceFrom, priceTo, name);
        List<GoodsDto> result = new ArrayList<>(list.size());
        for (Goods goods : list) {
            result.add(EntityDtoConverter.convert(goods));
        }
        return result;
    }

    @Override
    public void create(GoodsDto goodsDto) {
        goodsDao.create(EntityDtoConverter.convert(goodsDto));
    }

    @Override
    public void update(GoodsDto goodsDto) {
        goodsDao.update(EntityDtoConverter.convert(goodsDto));
    }

    @Override
    public void deleteById(Integer id) {
        goodsDao.deleteById(id);
    }
}
