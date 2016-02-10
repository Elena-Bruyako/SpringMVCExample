package com.bruyako;

/**
 * Created by brunyatko on 03.02.16.
 */
public interface AbstractDao<T, P> {

    void create(T t);
    void update(T t);
    void deleteById(P p);

}
