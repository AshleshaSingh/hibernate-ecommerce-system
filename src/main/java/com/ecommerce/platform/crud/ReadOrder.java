package com.ecommerce.platform.crud;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ecommerce.platform.entity.Orders;

public class ReadOrder {

    public ReadOrder(SessionFactory sessionFactory) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Orders> orders = session.createQuery(
        	    "select distinct o from Orders o " +
        	    "join fetch o.users " +
        	    "join fetch o.orderDetails od " +
        	    "join fetch od.product",
        	    Orders.class
        	).getResultList();

        for (Orders order : orders) {
            System.out.println("Order ID: " + order.getId());
            System.out.println("User: " + order.getUsers().getUsername());
            order.getOrderDetails().forEach(d ->
                    System.out.println("Product: " + d.getProduct().getName())
            );
        }

        session.close();
    }
}