package com.hannastable.resources;

import com.hannastable.dtos.DishDTO;
import com.hannastable.models.Dish;
import com.hannastable.services.DishesServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path("/dishes")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class DishesResource {

    @GET
    @Path("/{id}")
    public Dish getOneDish(@PathParam("id") int id){
        DishesServices dishesServices = new DishesServices();
        Dish returnedDish = dishesServices.getOneDish(id);
        return returnedDish;
    }

    @GET
    public ArrayList<DishDTO> getAllDishes(){
        DishesServices dishesServices = new DishesServices();
        ArrayList<DishDTO> dishList = dishesServices.getAllDishes();
        return dishList;
    }

    @POST
    public Dish createDish(Dish dish) throws Exception {
        DishesServices dishesServices = new DishesServices();
        Dish returnedDish = dishesServices.createDish(dish);
        return returnedDish;
    }
}
