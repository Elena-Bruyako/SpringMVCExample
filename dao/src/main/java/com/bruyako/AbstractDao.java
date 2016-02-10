package com.bruyako;

/**
 * Created by brunyatko on 03.02.16.
 */
public interface AbstractDao<T>{

    void create(T t);
    void update(T t);
    void deleteById(Long id);

}
