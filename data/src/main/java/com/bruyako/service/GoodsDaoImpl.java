package com.bruyako.service;

import com.bruyako.GoodsDao;
import com.bruyako.entity.Goods;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

        List<Goods> goods = getSession().createQuery("from Goods g").list();
        return goods;
    }

    @Override
    public List<Goods> getByFilter(int priceFrom, int priceTo, String name) {

        Criteria criteria = getSession().createCriteria(Goods.class);

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

    @Override
    public void create(Goods goods) {
        getSession().save(goods);
    }

    @Override
    public void update(Goods goods) {
        getSession().saveOrUpdate(goods);
    }

    @Override
    public void deleteById(Long id) {

        Query query = getSession().createQuery("delete from Goods g where g.goodId = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
}
