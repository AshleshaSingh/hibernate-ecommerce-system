package com.ecommerce.platform.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ecommerce.platform.entity.Role;
import com.ecommerce.platform.entity.Users;

public class CreateUser {
	public CreateUser(SessionFactory sessionFactory) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Users user = new Users();
        user.setUsername("ashlesha");
        user.setEmail("ashlesha@gmail.com");
        user.setPassword(hash("password123"));
        user.setRole(Role.CUSTOMER);

        session.persist(user);

        session.getTransaction().commit();
        session.close();

        System.out.println("User created successfully");
    }

    private String hash(String password) {
        return Integer.toHexString(password.hashCode());
    }
}
