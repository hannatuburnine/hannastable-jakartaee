package com.hannastable.services;

import com.hannastable.daos.OrdersDao;
import com.hannastable.models.Order;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OrdersService {

    public Order createOneOrder(int id, Order order) throws Exception{
        if (order.getPrice() >= 0 && order.getId() != 0) {
            OrdersDao ordersDao = new OrdersDao();
            Order returnedOrder = ordersDao.createOneOrder(id, order);
            return returnedOrder;
        } else {
            throw new Exception("Invalid Order");
        }
    }

    public ArrayList<Order> getAllOrders() {
        OrdersDao ordersDao = new OrdersDao();
        ArrayList<Order> returnedOrder = ordersDao.getAllOrders();
        return returnedOrder;
    }


    public Order getOneOrder(int id){
        OrdersDao ordersDao = new OrdersDao();
        Order returnedOrder = ordersDao.getOneOrder(id);
        return null;
    }
}
