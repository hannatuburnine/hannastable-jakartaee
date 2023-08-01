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
        TypedQuery query = manager.createQuery("SELECT D FROM Dish D", Dish.class);
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

    public Dish removeDish(int id){
        EntityManagerFactory factory = createEntityManagerFactory();
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        TypedQuery<Dish> query = (TypedQuery) manager.createQuery("SELECT D FROM Dish D WHERE D.id = :idOfTheDishToBeDeleted", Dish.class);
        query.setParameter("idOfTheDishToBeDeleted", id);
        Dish dishToRemove = query.getSingleResult();
        manager.remove(dishToRemove);
        manager.getTransaction().commit();
        return dishToRemove;
    }

    public Dish updateDish(int id){
        EntityManagerFactory factory = createEntityManagerFactory();
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        TypedQuery<Dish> query = (TypedQuery) manager.createQuery("SELECT D FROM Dish D WHERE D.id = :idOfTheDishToBeUpdated", Dish.class);
        query.setParameter("idOfTheDishToBeUpdated", id);
        Dish dishToUpdate = query.getSingleResult();
        manager.merge(dishToUpdate);
        manager.getTransaction().commit();
        return dishToUpdate;
    }


    public EntityManagerFactory createEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("hannastabledb_pu");
    }

}
