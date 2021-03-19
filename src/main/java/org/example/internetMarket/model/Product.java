package org.example.internetMarket.model;

import java.math.BigDecimal;

public class Product {
    private int product_id;
    private String name;
    private String category;
    private BigDecimal price;

    public Product() {
    }

    public Product(int product_id, String name, String category, BigDecimal price) {
        this.product_id = product_id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getProductId() {
        return product_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
