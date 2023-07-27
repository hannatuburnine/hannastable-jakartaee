package com.hannastable.daos;

import com.hannastable.dtos.DishesDTO;
import com.hannastable.models.Dishes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;

public class DishesDao {

    public Dishes getOneDish(int id){
        EntityManagerFactory factory = createEntityManagerFactory();
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Dishes> query = (TypedQuery<Dishes>) manager.createQuery("SELECT D FROM Dishes D WHERE D.id = :idOfTheDish", Dishes.class);
        query.setParameter("idOfTheDish", id);
        Dishes dish = query.getSingleResult();
        return dish;
    }

    public ArrayList<Dishes> getAllDishes(){
        EntityManagerFactory factory = createEntityManagerFactory();
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Dishes> query = manager.createQuery("SELECT D FROM Dishes D", Dishes.class);
        ArrayList<Dishes> list = (ArrayList<Dishes>) query.getResultList();
        return list;
    }

    public EntityManagerFactory createEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("hannastabledb_pu");
    }
}
