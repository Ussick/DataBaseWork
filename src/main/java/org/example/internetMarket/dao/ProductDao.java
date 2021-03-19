package org.example.internetMarket.dao;

import org.example.internetMarket.DbConnectionUtils;
import org.example.internetMarket.model.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao <Product> {

    @Override
    public Product findByid(int id) {
        try (Connection connection= DbConnectionUtils.getConnection()){
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM products WHERE product_id=?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            return convertToModel(resultSet);
        } catch (SQLException sqlException) {
            System.out.println("Request is not executed");
            throw new RuntimeException(sqlException);
        }
    }

    protected Product convertToModel(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            int product_id=resultSet.getInt(1);
            String name=resultSet.getString(2);
            String category=resultSet.getString(3);
            BigDecimal price=resultSet.getBigDecimal(4);
            Product product=new Product(product_id,name, category, price);
            return product;
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products=new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try (Connection connection= DbConnectionUtils.getConnection()){
            statement=connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM products;");
            while (resultSet.next()){
                Product product=new Product();
                product.setProduct_id(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setCategory(resultSet.getString(3));
                product.setPrice(resultSet.getBigDecimal(4));
                products.add(product);
            }
        } catch (SQLException sqlException) {
            System.out.println("Request is not executed");
            throw new RuntimeException(sqlException);
        }
        return products;
    }

    @Override
    public void create(Product model) {
        try {
            Connection connection=DbConnectionUtils.getConnection();
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO products VALUES (?, ?, ?, ?);");
            statement.setInt(1, model.getProductId());
            statement.setString(2, model.getName());
            statement.setString(3, model.getCategory());
            statement.setBigDecimal(4, model.getPrice());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void update(Product model) {
        try {
            Connection connection=DbConnectionUtils.getConnection();
            PreparedStatement statement = connection
                    .prepareStatement("UPDATE products SET name=?, category=?, price=? WHERE product_id=?");
            statement.setString(1, model.getName());
            statement.setString(2, model.getCategory());
            statement.setBigDecimal(3, model.getPrice());
            statement.setInt(4, model.getProductId());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


    @Override
    public void deleteById(int id) {
        try {
            Connection connection=DbConnectionUtils.getConnection();
            PreparedStatement statement = connection
                    .prepareStatement("DELETE FROM products WHERE product_id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
