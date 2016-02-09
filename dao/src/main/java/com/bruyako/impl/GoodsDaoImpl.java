package com.bruyako.impl;

import com.bruyako.GoodsDao;
import com.bruyako.converter.EntityDtoConverter;
import com.bruyako.entity.Goods;
import com.bruyako.model.GoodsDto;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunyatko on 03.02.16.
 */
@Transactional
@Repository
public class GoodsDaoImpl implements GoodsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<GoodsDto> getAll() {

        List<Goods> goods = sessionFactory.getCurrentSession().createQuery("select g from Goods g").list();
        List<GoodsDto> result = new ArrayList<>(goods.size());

        for (Goods good : goods) {
            result.add(EntityDtoConverter.convert(good));
        }
        return result;
    }

    @Override
    public List<GoodsDto> getByFilter(int priceFrom, int priceTo, String name) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Goods.class);
        if (priceFrom != 0) {
            criteria.add(Restrictions.ge("price", priceFrom));
        }
        if (priceTo != 0) {
            criteria.add(Restrictions.le("price", priceTo));
        }
        if (name != null) {
            criteria.add(Restrictions.like("name", "%" + name + "%"));
        }
        List<Goods> goodsList = criteria.list();
        List<GoodsDto> result = new ArrayList<>(goodsList.size());

        for (Goods goods : goodsList) {
            result.add(EntityDtoConverter.convert(goods));
        }
        if (result.isEmpty()) {
            System.out.println("Goods not found");
        }
        return result;
    }

    @Transactional(readOnly = false)
    @Override
    public void create(GoodsDto goodsDto) {

        Goods goods = EntityDtoConverter.convert(goodsDto);
        sessionFactory.getCurrentSession().save(goods);

    }

    @Transactional(readOnly = false)
    @Override
    public void update(GoodsDto goodsDto) {

        Goods goods = EntityDtoConverter.convert(goodsDto);
        sessionFactory.getCurrentSession().saveOrUpdate(goods);

    }

    @Override
    public void delete(Integer id) {

        Goods goods = new Goods();
        goods.setGood_id(id);
        sessionFactory.getCurrentSession().delete(goods);
    }
}
