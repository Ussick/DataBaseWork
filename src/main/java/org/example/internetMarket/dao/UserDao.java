package org.example.internetMarket.dao;

import org.example.internetMarket.DbConnectionUtils;
import org.example.internetMarket.model.Product;
import org.example.internetMarket.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {

    protected User convertToModel(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            int user_id=resultSet.getInt(1);
            String name=resultSet.getString(2);
            String address=resultSet.getString(3);
            String email=resultSet.getString(4);
            String gender=resultSet.getString(5);
            LocalDate date_of_birth=resultSet.getDate(6).toLocalDate();
            User user=new User(user_id, name, address, email, gender, date_of_birth);
            return user;
        }
        return null;
    }

    @Override
    public User findByid(int id) {
        try (Connection connection= DbConnectionUtils.getConnection()){
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM users WHERE user_id=?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            return convertToModel(resultSet);
        } catch (SQLException sqlException) {
            System.out.println("Request is not executed");
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users=new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try (Connection connection= DbConnectionUtils.getConnection()){
            statement=connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users;");
            while (resultSet.next()){
                User user=new User();
                user.setUser_id(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAddress(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setGender(resultSet.getString(5));
                user.setDate_Of_Birth(resultSet.getDate(6).toLocalDate());
                users.add(user);
            }
        } catch (SQLException sqlException) {
            System.out.println("Request is not executed");
            throw new RuntimeException(sqlException);
        }
        return users;
    }

    @Override
    public void create(User model) {
        try {
            Connection connection = DbConnectionUtils.getConnection();
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO users VALUES (?, ?, ?, ?, ?, ?);");
            statement.setInt(1, model.getUser_id());
            statement.setString(2, model.getName());
            statement.setString(3, model.getAddress());
            statement.setString(4, model.getEmail());
            statement.setString(5, model.getGender());
            statement.setDate(6, Date.valueOf(model.getDateOfBirth()));
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void update(User model) {
        try {
            Connection connection = DbConnectionUtils.getConnection();
            PreparedStatement statement = connection
                    .prepareStatement("UPDATE users SET name=?, address=?, email=?, gender=?, date_of_birth=? WHERE user_id=?");
            statement.setString(1, model.getName());
            statement.setString(2, model.getAddress());
            statement.setString(3, model.getEmail());
            statement.setString(4, model.getGender());
            statement.setDate(5, Date.valueOf(model.getDateOfBirth()));
            statement.setInt(6, model.getUser_id());
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
                    .prepareStatement("DELETE FROM users WHERE user_id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public User findByEmail(String email) {
        try (Connection connection= DbConnectionUtils.getConnection()){
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM users WHERE email=?");
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            return convertToModel(resultSet);
        } catch (SQLException sqlException) {
            System.out.println("Request is not executed");
            throw new RuntimeException(sqlException);
        }
    }

    public User findByBirth(LocalDate date_of_Birth) {
        try (Connection connection= DbConnectionUtils.getConnection()){
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM users WHERE date_of_birth=?");
            statement.setDate(1,Date.valueOf(date_of_Birth));
            ResultSet resultSet = statement.executeQuery();
            return convertToModel(resultSet);
        } catch (SQLException sqlException) {
            System.out.println("Request is not executed");
            throw new RuntimeException(sqlException);
        }
    }
}
