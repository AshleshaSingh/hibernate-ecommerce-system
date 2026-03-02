package com.ecommerce.platform.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ecommerce.platform.entity.Category;
import com.ecommerce.platform.entity.OrderDetails;
import com.ecommerce.platform.entity.Orders;
import com.ecommerce.platform.entity.Product;
import com.ecommerce.platform.entity.Users;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Category.class);
			cfg.addAnnotatedClass(Product.class);
			cfg.addAnnotatedClass(Users.class);
			cfg.addAnnotatedClass(Orders.class);
			cfg.addAnnotatedClass(OrderDetails.class);
			
			return cfg.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("SessionFactory creation failed.");
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void shutdown() {
		getSessionFactory().close();
	}

}
