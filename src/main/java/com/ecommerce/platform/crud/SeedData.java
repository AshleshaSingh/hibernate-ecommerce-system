package com.ecommerce.platform.crud;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ecommerce.platform.entity.Category;
import com.ecommerce.platform.entity.Product;

public class SeedData {

    public SeedData(SessionFactory sessionFactory) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Category electronics = new Category();
        electronics.setName("Clothing");
        electronics.setDesc("Clothing Items");

        Category books = new Category();
        books.setName("Books");
        books.setDesc("Book Collection");

        session.persist(electronics);
        session.persist(books);

        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setPrice(new BigDecimal("1200"));
        p1.setStockQuantity(10);
        p1.setCategory(electronics);

        Product p2 = new Product();
        p2.setName("Mobile");
        p2.setPrice(new BigDecimal("800"));
        p2.setStockQuantity(15);
        p2.setCategory(electronics);

        Product p3 = new Product();
        p3.setName("Hibernate Book");
        p3.setPrice(new BigDecimal("50"));
        p3.setStockQuantity(30);
        p3.setCategory(books);

        session.persist(p1);
        session.persist(p2);
        session.persist(p3);

        session.getTransaction().commit();
        session.close();

        System.out.println("Seed data inserted");
    }
}