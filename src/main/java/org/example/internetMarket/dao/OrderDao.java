package org.example.internetMarket.dao;

import org.example.internetMarket.DbConnectionUtils;
import org.example.internetMarket.model.Order;
import org.example.internetMarket.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements DaoForOrders <Order> {

    @Override
    public Order findByid(int user_id, int product_id) {
        try (Connection connection= DbConnectionUtils.getConnection()){
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM orders WHERE user_id=? and product_id=?");
            statement.setInt(1,user_id);
            statement.setInt(2,product_id);
            ResultSet resultSet = statement.executeQuery();
            return convertToModel(resultSet);
        } catch (SQLException sqlException) {
            System.out.println("Request is not executed");
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders=new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try (Connection connection= DbConnectionUtils.getConnection()){
            statement=connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM orders;");
            while (resultSet.next()){
                Order order=new Order();
                order.setUser_id(resultSet.getInt(1));
                order.setProduct_id(resultSet.getInt(2));
                order.setCount(resultSet.getInt(3));
                order.setStatus(resultSet.getString(4));
                order.setDate(resultSet.getDate(5).toLocalDate());
                orders.add(order);
            }
        } catch (SQLException sqlException) {
            System.out.println("Request is not executed");
            throw new RuntimeException(sqlException);
        }
        return orders;
    }

    @Override
    public void create(Order model) {
        try {
            Connection connection = DbConnectionUtils.getConnection();
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO orders VALUES (?, ?, ?, ?, ?);");
            statement.setInt(1, model.getUser_id());
            statement.setInt(2, model.getProduct_id());
            statement.setInt(3, model.getCount());
            statement.setString(4, model.getStatus());
            statement.setDate(5, Date.valueOf(model.getDate()));
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void update(int user_id, int product_id, String status) {
        Order order=findByid(user_id, product_id);
        if (order==null){
            System.out.println("order with "+"user_id="+user_id+" and product_id="+product_id+" is absent");
        }
        else{
            try { Connection connection = DbConnectionUtils.getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("UPDATE orders SET status=? WHERE user_id=? AND product_id=?");
                statement.setString(1, status);
                statement.setInt(2, order.getUser_id());
                statement.setInt(3, order.getProduct_id());
                statement.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    @Override
    public List<Order> findByUserId(int user_id) {
        List<Order> orders=new ArrayList<>();
        PreparedStatement statement  = null;
        ResultSet resultSet = null;
        try (Connection connection= DbConnectionUtils.getConnection()){
            statement=connection.prepareStatement("SELECT * FROM orders WHERE user_id=?;");
            statement.setInt(1, user_id);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Order order=new Order();
                order.setUser_id(resultSet.getInt(1));
                order.setProduct_id(resultSet.getInt(2));
                order.setCount(resultSet.getInt(3));
                order.setStatus(resultSet.getString(4));
                order.setDate(resultSet.getDate(5).toLocalDate());
                orders.add(order);
            }
        } catch (SQLException sqlException) {
            System.out.println("Request is not executed");
            throw new RuntimeException(sqlException);
        }
        return orders;
    }

    @Override
    public List<Order> findByUserIdStatus(int user_id, String status) {
        List<Order> orders=new ArrayList<>();
        PreparedStatement statement  = null;
        ResultSet resultSet = null;
        try (Connection connection= DbConnectionUtils.getConnection()){
            statement=connection.prepareStatement("SELECT * FROM orders WHERE user_id=? AND status=?;");
            statement.setInt(1, user_id);
            statement.setString(2, status);

            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Order order=new Order();
                order.setUser_id(resultSet.getInt(1));
                order.setProduct_id(resultSet.getInt(2));
                order.setCount(resultSet.getInt(3));
                order.setStatus(resultSet.getString(4));
                order.setDate(resultSet.getDate(5).toLocalDate());
                orders.add(order);
            }
        } catch (SQLException sqlException) {
            System.out.println("Request is not executed");
            throw new RuntimeException(sqlException);
        }
        return orders;
    }

    protected Order convertToModel(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            int user_id=resultSet.getInt(1);
            int product_id=resultSet.getInt(2);
            int count=resultSet.getInt(3);
            String status=resultSet.getString(4);
            LocalDate date=resultSet.getDate(5).toLocalDate();
            Order order=new Order(user_id, product_id, count, status, date);
            return order;
        }
        return null;
    }
}
