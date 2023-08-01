package com.hannastable.daos;


import com.hannastable.models.Ingredient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


import java.util.ArrayList;

public class IngredientDao {

    public ArrayList<Ingredient> getAllIngredients(){
        EntityManagerFactory factory = createEntityManagerFactory();
        EntityManager manager = factory.createEntityManager();
        TypedQuery query = manager.createQuery("SELECT I FROM Ingredient I JOIN I.dish", Ingredient.class);
        ArrayList<Ingredient> ingredientList = (ArrayList<Ingredient>) query.getResultList();
        return ingredientList;
    }

    public Ingredient getOneIngredient(String ingredientName){
        EntityManagerFactory factory = createEntityManagerFactory();
        EntityManager manager = factory.createEntityManager();
        TypedQuery query = manager.createQuery("SELECT I FROM Ingredient I WHERE I.ingredientName = :nameOfTheIngredient", Ingredient.class);
        query.setParameter("nameOfTheIngredient", ingredientName);
        Ingredient ingredient = (Ingredient) query.getSingleResult();
        return ingredient;
    }

    public Ingredient createIngredient(Ingredient ingredient){
        EntityManagerFactory factory = createEntityManagerFactory();
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(ingredient);
        manager.getTransaction().commit();
        return ingredient;
    }

    public EntityManagerFactory createEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("hannastabledb_pu");
    }
}
