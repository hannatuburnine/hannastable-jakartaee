package com.hannastable.resources;

import com.hannastable.models.Client;
import com.hannastable.models.Order;
import jakarta.persistence.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path("/orders")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class OrdersResource {


    @POST
    @Path("/client/{id}")
    public void createOneOrder(@PathParam("id") int id, Order order){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hannastabledb_pu");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(order);
        manager.getTransaction().commit();
    }

    @GET
    @Path("/orders")
    public ArrayList<Order> getAllOrders(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hannastabledb_pu");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Order> query = manager.createQuery("SELECT O FROM Order O ", Order.class);
        ArrayList<Order> listOrder = (ArrayList<Order>) query.getResultList();
        return listOrder;
    }
}
