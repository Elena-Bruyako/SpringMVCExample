package com.bruyako;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by brunyatko on 03.02.16.
 */
public class App {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        GoodsDao goodsDao = context.getBean(GoodsDao.class);
        System.out.println(goodsDao.getByName("i"));
    }
}
