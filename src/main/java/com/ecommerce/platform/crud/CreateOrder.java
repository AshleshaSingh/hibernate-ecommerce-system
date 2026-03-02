package com.ecommerce.platform.crud;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ecommerce.platform.entity.*;

public class CreateOrder {
	public CreateOrder(SessionFactory sessionFactory) {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Users user = session.get(Users.class, 1L);
        Product product = session.get(Product.class, 1L);

        Orders order = new Orders();
        order.setOrderDate(LocalDateTime.now());

        OrderDetails detail = new OrderDetails();
        detail.setProduct(product);
        detail.setQuantity(2);
        detail.setUnitPrice(product.getPrice());
        detail.setOrders(order);;

        order.getOrderDetails().add(detail);
        order.setUsers(user);
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(2)));

        session.persist(order);

        session.getTransaction().commit();
        session.close();

        System.out.println("Order created successfully");
    }
}
