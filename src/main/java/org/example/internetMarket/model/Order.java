package org.example.internetMarket.model;

import java.time.LocalDate;

public class Order {
    private int user_id;
    private int product_id;
    private int count;
    private String status;
    private LocalDate date;

    public Order(int user_id, int product_id, int count, String status, LocalDate date) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.count = count;
        this.status = status;
        this.date = date;
    }

    public Order() {
    }

    public int getUser_id() {
        return user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getCount() {
        return count;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "user_id=" + user_id +
                ", product_id=" + product_id +
                ", count=" + count +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
