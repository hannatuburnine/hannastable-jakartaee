package com.hannastable.daos;

import com.hannastable.models.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class OrdersDao {

    public Order createOneOrder(Order order){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hannastabledb_pu");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(order);
        manager.getTransaction().commit();
        return order;
    }

    public ArrayList<Order> getAllOrders(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hannastabledb_pu");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Order> query = manager.createQuery("SELECT O FROM Order O JOIN O.client", Order.class);
        ArrayList<Order> listOrder = (ArrayList<Order>) query.getResultList();
        return listOrder;
    }

    public Order getOneOrder(int id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hannastabledb_pu");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Order> query = manager.createQuery("SELECT O FROM Order O WHERE O.id = :idOfTheOrder", Order.class);
        query.setParameter("idOfTheOrder", id);
        Order order = (Order) query.getSingleResult();
        return order;
    }

    public Order deleteOrder(int id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hannastabledb_pu");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        TypedQuery<Order> query = manager.createQuery("SELECT O FROM Order O WHERE O.id = :idOfTheOrder", Order.class);
        query.setParameter("idOfTheOrder", id);
        Order order = query.getSingleResult();
        manager.remove(order);
        manager.getTransaction().commit();
        return null;
    }

    public Order updateOrder(int id, Order updatedPrice){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hannastabledb_pu");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        TypedQuery<Order> query = manager.createQuery("SELECT O FROM Order O WHERE O.id = :idOfTheOrderToUpdate", Order.class);
        query.setParameter("idOfTheOrderToUpdate", id);
        Order order = query.getSingleResult();
        order.setPrice(updatedPrice.getPrice());
        manager.merge(order);
        manager.getTransaction().commit();
        return order;
    }
    
}
