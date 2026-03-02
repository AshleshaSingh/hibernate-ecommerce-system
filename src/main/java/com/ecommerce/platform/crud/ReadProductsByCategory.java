package com.ecommerce.platform.crud;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ecommerce.platform.entity.Product;

public class ReadProductsByCategory {

    public ReadProductsByCategory(SessionFactory sessionFactory) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Product> products = session
                .createNamedQuery("Product.findActiveByCategory", Product.class)
                .setParameter("categoryName", "Electronics")
                .getResultList();

        for (Product p : products) {
            System.out.println("Product: " + p.getName());
        }

        session.getTransaction().commit();
        session.close();
    }
}