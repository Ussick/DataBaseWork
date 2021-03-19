package org.example.internetMarket.dao;

import java.util.List;

public interface DaoForOrders <T>{

    T findByid(int user_id, int product_id);

    List<T> findAll();

    void create(T model);

    void update(int user_id, int product_id, String status);


    List<T> findByUserId(int user_id);

    List<T> findByUserIdStatus(int user_id, String status);
}
