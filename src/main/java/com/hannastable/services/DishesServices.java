package com.hannastable.services;

import com.hannastable.daos.DishesDao;
import com.hannastable.dtos.DishesDTO;
import com.hannastable.dtos.IngredientsDTO;
import com.hannastable.models.Dishes;
import com.hannastable.models.Ingredients;

import java.util.ArrayList;

public class DishesServices {

    public Dishes getOneDish(int id){
        DishesDao dishesDao = new DishesDao();
        Dishes returnedDish = dishesDao.getOneDish(id);
        return returnedDish;
    }

    public ArrayList<Dishes> getAllDishes(){
        DishesDao dishesDao = new DishesDao();
        ArrayList<Dishes> returnedDish = new ArrayList<>();
        ArrayList<Dishes> dishesDTO = dishesDao.getAllDishes();

        for (int i = 0; i < returnedDish.size(); i++){
            Dishes dish = returnedDish.get(i);
            DishesDTO dishDTO = new DishesDTO();
            dishDTO.setName(dish.getName());
            dishDTO.setId(dish.getId());

            for (int j = 0; j < dish.getIngredients().size(); j++){
                Ingredients ingredient = dish.getIngredients().get(j);

                IngredientsDTO ingredientsDTO = new IngredientsDTO();
                ingredientsDTO.setIngredientName(ingredient.getIngredientName());
                ingredientsDTO.setExpiringDate(ingredient.getExpiringDate());
                ingredientsDTO.setBatch(ingredient.getBatch());

                dishDTO.getIngredients().add(ingredientsDTO);
            }
        }
       return dishesDTO;
    }
}
