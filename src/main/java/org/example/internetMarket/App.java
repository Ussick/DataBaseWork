package org.example.internetMarket;

import org.example.internetMarket.dao.OrderDao;
import org.example.internetMarket.dao.ProductDao;
import org.example.internetMarket.dao.StateOfStatus;
import org.example.internetMarket.dao.UserDao;
import org.example.internetMarket.model.Order;
import org.example.internetMarket.model.Product;
import org.example.internetMarket.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Tables.createUsersTable(false);
        Tables.createProductsTable(false);
        Tables.createOrdersTable(false);

//        new ProductDao().create(product1);
//        Product product2=new Product(2, "Samsung Phone", "Phone", BigDecimal.valueOf(5060.25).setScale(2));
//        new ProductDao().create(product2);

//        Product product1 = new Product(1, "Samsung TV", "TV", BigDecimal.valueOf(10000.00).setScale(2));
//        Product product = new ProductDao().findByid(1);
//        System.out.println(product);
//        product1.setName("SAMSUNG TV");
//        product1.setPrice(BigDecimal.valueOf(11000.10));
//        new ProductDao().update(product1);
//        System.out.println(new ProductDao().findByid(1));
//        new ProductDao().deleteById(2);
//        new ProductDao().findAll().stream().forEach(System.out::println);
//        ProductDao productDao=new ProductDao();
//        UserDao userDao = new UserDao();
//        User user1=new User(1,"Vasya", "Kyiv, pr.Peremogy,25", "vaso123@gmail.com", "male", LocalDate.of(2000,12,31));
//        User user2=new User(2,"Chloe", "Usa, Dallas, Avenue 8", "good_girl13@gmail.com", "female", LocalDate.of(1999,04,01));
//        userDao.create(user2);
//        user1.setAddress("Ukraine, Kyiv, pr.Peremogy,25");
//        user1.setDate_Of_Birth(LocalDate.of(1998,6,07));
//
//        userDao.update(user1);
//        System.out.println(userDao.findByid(1));
//        System.out.println(userDao.findByEmail("good_girl13@gmail.com"));
//        System.out.println(userDao.findByBirth(LocalDate.of(1998,6,07)));
//        userDao.findAll().stream().forEach(System.out::println);
//        userDao.deleteById(2);
//        userDao.findAll().stream().forEach(System.out::println);
//        User user3 = new User(3, "Petya", "Ukraine, Hkarkiv, Nauka prospect", "bad_boy24@gmail.com", "male", LocalDate.of(1984, 10, 24));
//        userDao.create(user3);
//        Product product3=new Product(3, "Car Honda", "Car", BigDecimal.valueOf(1000001.23));
//        productDao.create(product3);

        OrderDao orderDao=new OrderDao();
        Order order1=new Order(1,1,1, StateOfStatus.ACCEPTED.name(), LocalDate.of(2021,03,18));
        Order order2=new Order(1,2,3, StateOfStatus.IN_PROGRESS.name(), LocalDate.of(2021,03,15));

        Order order3=new Order(2,2,2, StateOfStatus.ACCEPTED.name(), LocalDate.of(2021,03,18));
        Order order4=new Order(2,3,1, StateOfStatus.CANCELLED.name(), LocalDate.of(2020,12,10));

        Order order5=new Order(3,1,4, StateOfStatus.PERFORMED.name(), LocalDate.of(2021,02,03));
        Order order6=new Order(3,3,1, StateOfStatus.IN_PROGRESS.name(), LocalDate.of(2021,01,01));

//        orderDao.create(order1);
//        orderDao.create(order2);
//        orderDao.create(order3);
//        orderDao.create(order4);
//        orderDao.create(order5);
//        orderDao.create(order6);

//        orderDao.update(1,1, StateOfStatus.IN_PROGRESS.name());

//        orderDao.findByUserIdStatus(1, StateOfStatus.IN_PROGRESS.name()).stream().forEach(System.out::println);
//        orderDao.findByUserId(2).stream().forEach(System.out::println);
        orderDao.findAll().stream().forEach(System.out::println);



    }
}
