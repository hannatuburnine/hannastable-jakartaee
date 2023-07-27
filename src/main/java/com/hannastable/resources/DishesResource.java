package com.hannastable.resources;

import com.hannastable.models.Dishes;
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
    public Dishes getOneDish(@PathParam("id") int id){
        DishesServices dishesServices = new DishesServices();
        Dishes returnedDish = dishesServices.getOneDish(id);
        return returnedDish;
    }

    @GET
    public ArrayList<Dishes> getAllDishes(){
        DishesServices dishesServices = new DishesServices();
        ArrayList<Dishes> dishList = dishesServices.getAllDishes();
        return dishList;
    }
}
