package com.ecommerce.platform.crud;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ecommerce.platform.entity.Category;
import com.ecommerce.platform.entity.Product;

public class CreateProduct {
	public CreateProduct(SessionFactory sessionFactory) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Category category = session.get(Category.class, 1L);

        Product product1 = new Product();
        product1.setName("Laptop");
        product1.setPrice(new BigDecimal("1200.00"));
        product1.setStockQuality(10);
        product1.setCategory(category);

        session.persist(product1);
        
        Product product2 = new Product();
        product2.setName("Mobile");
        product2.setPrice(new BigDecimal("800.00"));
        product2.setStockQuality(5);
        product2.setCategory(category);

        session.persist(product2);
        
        Product product3 = new Product();
        product3.setName("Tablet");
        product3.setPrice(new BigDecimal("1000.00"));
        product3.setStockQuality(8);
        product3.setCategory(category);

        session.persist(product3);

        session.getTransaction().commit();
        session.close();

        System.out.println("Product created successfully");
    }
}
