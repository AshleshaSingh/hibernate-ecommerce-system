package com.ecommerce.platform.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ecommerce.platform.entity.Category;

public class CreateCategory {
	public CreateCategory(SessionFactory sessionFactory) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Category category = new Category();
        category.setName("Electronics");
        category.setDesc("Electronic items");

        session.persist(category);

        session.getTransaction().commit();
        session.close();

        System.out.println("Category created successfully");
    }
}
