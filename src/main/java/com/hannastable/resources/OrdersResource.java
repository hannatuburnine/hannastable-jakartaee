package com.hannastable.resources;

import com.hannastable.models.Client;
import com.hannastable.models.Order;
import com.hannastable.services.ClientsService;
import com.hannastable.services.OrdersService;
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
    public Order createOneOrder(@PathParam("id") int id, Order order) throws Exception{
        OrdersService ordersService = new OrdersService();
        Order returnedOrder = ordersService.createOneOrder(id, order);
        return returnedOrder;
    }

    @GET
    @Path("/orders")
    public ArrayList<Order> getAllOrders(){
        OrdersService ordersService = new OrdersService();
        ArrayList<Order> returnedOrder = ordersService.getAllOrders();
        return returnedOrder;
    }

    @GET
    @Path("/{id}")
    public Order getOneorder(@PathParam("id") int id){
        OrdersService ordersService = new OrdersService();
        Order returnedOrder = ordersService.getOneOrder(id);
        return returnedOrder;
    }
}
