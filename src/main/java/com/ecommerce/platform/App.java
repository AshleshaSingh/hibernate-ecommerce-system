package com.ecommerce.platform;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ecommerce.platform.util.HibernateUtil;
import com.ecommerce.platform.crud.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

//        new CreateCategory(sessionFactory);
//        new CreateProduct(sessionFactory);
//        new CreateUser(sessionFactory);
//        new CreateOrder(sessionFactory);
//        new ReadOrder(sessionFactory);
//    	new SoftDeleteProduct(sessionFactory);
    	new ReadProductsByCategory(sessionFactory);
//    	new ReadProductsWithPagination(sessionFactory, 1, 2);
//    	new ReadProductsWithPagination(sessionFactory, 2, 2);
//    	new SeedData(sessionFactory);

        sessionFactory.close();
    }
}
