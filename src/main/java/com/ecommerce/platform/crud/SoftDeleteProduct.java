package com.ecommerce.platform.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ecommerce.platform.entity.Product;

public class SoftDeleteProduct {

    public SoftDeleteProduct(SessionFactory sessionFactory) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Product product = session.get(Product.class, 1L);

        if (product != null) {
            product.setDeleted(true);
            session.merge(product);
            System.out.println("Product soft deleted successfully");
        }

        session.getTransaction().commit();
        session.close();
    }
}
