package org.example.internetMarket.dao;

import java.util.List;

public interface Dao<T> {
    T findByid(int id);

    List<T> findAll();

    void create(T model);

    void update(T model);

    void deleteById(int id);

}
