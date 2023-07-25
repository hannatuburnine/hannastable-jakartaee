package com.hannastable.resources;

import com.hannastable.dtos.OrderDTO;
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
    @Path("orders")
    public ArrayList<OrderDTO> getAllOrders(){
        OrdersService ordersService = new OrdersService();
        ArrayList<OrderDTO> returnedOrder = ordersService.getAllOrders();
        return returnedOrder;
    }

    @GET
    @Path("/{id}")
    public Order getOneorder(@PathParam("id") int id){
        OrdersService ordersService = new OrdersService();
        Order returnedOrder = ordersService.getOneOrder(id);
        return returnedOrder;
    }

    @DELETE
    @Path("/{id}")
    public void deleteOrder(@PathParam("id") int id){
    OrdersService ordersService = new OrdersService();
    Order returnedOrder = ordersService.deleteOrder(id);
    }

    @PUT
    @Path("/{id}")
    public Order updateOrder(@PathParam("id") int id, Order updatedPrice){
        OrdersService ordersService = new OrdersService();
        Order returnedOrder = ordersService.updateOrder(id, updatedPrice);
        return returnedOrder;
    }
}
