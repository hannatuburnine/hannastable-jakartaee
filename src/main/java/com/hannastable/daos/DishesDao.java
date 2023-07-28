package com.hannastable.daos;

import com.hannastable.models.Dish;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;

public class DishesDao {

    public Dish getOneDish(int id){
        EntityManagerFactory factory = createEntityManagerFactory();
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Dish> query = (TypedQuery<Dish>) manager.createQuery("SELECT D FROM Dish D WHERE D.id = :idOfTheDish", Dish.class);
        query.setParameter("idOfTheDish", id);
        Dish dish = query.getSingleResult();
        return dish;
    }

    public ArrayList<Dish> getAllDishes(){
        EntityManagerFactory factory = createEntityManagerFactory();
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Dish> query = manager.createQuery("SELECT D FROM Dish D", Dish.class);
        ArrayList<Dish> list = (ArrayList<Dish>) query.getResultList();
        return list;
    }

    public Dish createDish(Dish dish) {
        EntityManagerFactory factory = createEntityManagerFactory();
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(dish);
        manager.getTransaction().commit();
        return dish;
    }

    public EntityManagerFactory createEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("hannastabledb_pu");
    }


}
