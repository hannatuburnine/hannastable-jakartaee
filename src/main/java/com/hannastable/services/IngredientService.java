package com.hannastable.services;


import com.hannastable.daos.IngredientDao;
import com.hannastable.dtos.IngredientDTO;
import com.hannastable.models.Ingredient;

import java.util.ArrayList;

public class IngredientService {

    public ArrayList<IngredientDTO> getAllIngredients(){
        IngredientDao ingredientDao = new IngredientDao();
        ArrayList<Ingredient> returnedIngredient = ingredientDao.getAllIngredients();
        ArrayList<IngredientDTO> ingredientsDTO = new ArrayList<>();

        for (int i = 0; i < returnedIngredient.size(); i++){
            Ingredient ingredient = returnedIngredient.get(i);
            IngredientDTO ingredientDTO = new IngredientDTO();
            ingredientDTO.setIngredientName(ingredient.getIngredientName());
            ingredientDTO.setBatch(ingredient.getBatch());
            ingredientDTO.setExpiringDate(ingredient.getExpiringDate());

            ingredientsDTO.add(ingredientDTO);
        }
        return ingredientsDTO;
    }

    public Ingredient getOneIngredient(String ingredientName){
        IngredientDao ingredientDao = new IngredientDao();
        Ingredient returnedIngredient = ingredientDao.getOneIngredient(ingredientName);
        return returnedIngredient;
    }

    public Ingredient createIngredient(Ingredient ingredient){
        IngredientDao ingredientDao = new IngredientDao();
        Ingredient returnedIngredient = ingredientDao.createIngredient(ingredient);
        return returnedIngredient;
    }
}
