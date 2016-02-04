package com.bruyako.impl;

import com.bruyako.GoodDao;
import com.bruyako.converter.EntityDtoConverter;
import com.bruyako.entity.Good;
import com.bruyako.model.GoodDto;
import org.hibernate.SessionFactory;
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
public class GoodDaoImpl implements GoodDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<GoodDto> getAll() {

        List<Good> goods = sessionFactory.getCurrentSession().createQuery("from Good g").list();

        List<GoodDto> result = new ArrayList<GoodDto>(goods.size());

        for (Good good : goods) {
            result.add(EntityDtoConverter.convert(good));
        }
        return result;
    }

    @Transactional(readOnly = false)
    @Override
    public void create(GoodDto goodDto) {

        Good good = EntityDtoConverter.convert(goodDto);
        sessionFactory.getCurrentSession().save(good);
    }

    @Override
    public GoodDto read(Integer id) {

        Good good = (Good) sessionFactory.getCurrentSession().get(Good.class, id);
        return EntityDtoConverter.convert(good);
    }

    @Override
    public GoodDto update(GoodDto goodDto) {
        return null;
    }

    @Override
    public void delete(Integer id) {

        Good good = new Good();
        good.setGood_id(id);
        sessionFactory.getCurrentSession().delete(good);
    }
}
