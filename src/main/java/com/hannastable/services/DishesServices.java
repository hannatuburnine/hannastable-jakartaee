package com.hannastable.services;

import com.hannastable.daos.DishesDao;
import com.hannastable.dtos.DishDTO;
import com.hannastable.dtos.IngredientDTO;
import com.hannastable.models.Dish;
import com.hannastable.models.Ingredient;

import java.util.ArrayList;

public class DishesServices {

    public Dish getOneDish(int id){
        DishesDao dishesDao = new DishesDao();
        Dish returnedDish = dishesDao.getOneDish(id);
        return returnedDish;
    }

    public ArrayList<DishDTO> getAllDishes(){
        DishesDao dishesDao = new DishesDao();
        ArrayList<Dish> returnedDish = dishesDao.getAllDishes();
        ArrayList<DishDTO> dishesDTO = new ArrayList<>();

        for (int i = 0; i < returnedDish.size(); i++){
            Dish dish = returnedDish.get(i);
            DishDTO dishDTO = new DishDTO();
            dishDTO.setName(dish.getName());
            dishDTO.setId(dish.getId());

            for (int j = 0; j < dish.getIngredients().size(); j++){
                Ingredient ingredient = dish.getIngredients().get(j);

                IngredientDTO ingredientsDTO = new IngredientDTO();
                ingredientsDTO.setIngredientName(ingredient.getIngredientName());
                ingredientsDTO.setExpiringDate(ingredient.getExpiringDate());
                ingredientsDTO.setBatch(ingredient.getBatch());

                dishDTO.getIngredients().add(ingredientsDTO);
            }
        }
       return dishesDTO;
    }

    public Dish createDish(Dish dish) throws Exception {
        if (dish.getName().length() <= 10 && dish.getName().isBlank() == false) {
            DishesDao dishesDao = new DishesDao();
            Dish returnedDish = dishesDao.createDish(dish);
            return returnedDish;
        } else {
            throw new Exception("Nome inválido");
        }

    }

    public Dish removeDish(int id){
        DishesDao dishesDao = new DishesDao();
        Dish returnedDish = dishesDao.removeDish(id);
        return returnedDish;
    }

    public Dish updateDish(int id){
        DishesDao dishesDao = new DishesDao();
        Dish returnedDish = dishesDao.updateDish(id);
        return returnedDish;
    }
}
