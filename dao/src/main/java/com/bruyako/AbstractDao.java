package com.bruyako;

/**
 * Created by brunyatko on 03.02.16.
 */
public interface AbstractDao<T, P> {

    void create(T t);
    T update(T t);
    void delete(P p);

}
