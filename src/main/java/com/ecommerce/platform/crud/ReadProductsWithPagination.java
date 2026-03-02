package com.ecommerce.platform.crud;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ecommerce.platform.entity.Product;

public class ReadProductsWithPagination {

    public ReadProductsWithPagination(SessionFactory sessionFactory, int pageNumber, int pageSize) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        int offset = (pageNumber - 1) * pageSize;

        List<Product> products = session
                .createQuery("FROM Product p WHERE p.deleted = false", Product.class)
                .setFirstResult(offset)
                .setMaxResults(pageSize)
                .getResultList();

        System.out.println("Page " + pageNumber);

        if (products.isEmpty()) {
            System.out.println("No products found for page " + pageNumber);
        } else {
            for (Product product : products) {
                System.out.println("Product: " + product.getName());
            }
        }

        session.getTransaction().commit();
        session.close();
    }
}