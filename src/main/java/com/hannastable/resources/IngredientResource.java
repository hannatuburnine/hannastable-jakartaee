package com.hannastable.resources;



import com.hannastable.dtos.IngredientDTO;

import com.hannastable.models.Ingredient;
import com.hannastable.services.IngredientService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path("/ingredients")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class IngredientResource {

    @GET
    public ArrayList<IngredientDTO> getAllIngredients(){
        IngredientService ingredientService = new IngredientService();
        ArrayList<IngredientDTO> returnedIngredientList = ingredientService.getAllIngredients();
        return returnedIngredientList;
    }

    @GET
    @Path("/{ingredientName}")
    public Ingredient getOneIngredient(@PathParam("ingredientName") String ingredientName){
        IngredientService ingredientService = new IngredientService();
        Ingredient returnedIngredient = ingredientService.getOneIngredient(ingredientName);
        return returnedIngredient;
    }

    @POST
    public Ingredient createIngredient(Ingredient ingredient){
        IngredientService ingredientService = new IngredientService();
        Ingredient returnedIngredient = ingredientService.createIngredient(ingredient);
        return null;
    }

    @PUT
    @Path("/{ingredientName}")
    public Ingredient updateIngredient(@PathParam("ingredientName") String ingredientName){
        IngredientService ingredientService = new IngredientService();
        Ingredient returnedIngredient = ingredientService.updateIngredient(ingredientName);
        return returnedIngredient;
    }

}
