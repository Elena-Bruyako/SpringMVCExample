package com.bruyako.impl;

import com.bruyako.GoodsDao;
import com.bruyako.entity.Goods;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by brunyatko on 03.02.16.
 */
@Repository
public class GoodsDaoImpl implements GoodsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Goods> getAll() {

        List<Goods> goods = sessionFactory.getCurrentSession().createQuery("from Goods g").list();
        return goods;
    }

    @Override
    public List<Goods> getByFilter(int priceFrom, int priceTo, String name) {

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
        if (goodsList.isEmpty()) {
            System.out.println("Goods not found");
        }
        return goodsList;
    }

    @Transactional(readOnly = false)
    @Override
    public void create(Goods goods) {
        sessionFactory.getCurrentSession().save(goods);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Goods goods) {
        sessionFactory.getCurrentSession().saveOrUpdate(goods);
    }

    @Override
    public void deleteById(Integer id) {

        Goods goods = new Goods();
        goods.setGoodId(id);
        sessionFactory.getCurrentSession().delete(goods);
    }
}
