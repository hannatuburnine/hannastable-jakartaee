package com.hannastable.daos;

import com.hannastable.models.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;

public class ClientsDao {

    public Client createClient(Client client){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hannastabledb_pu");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(client);
        manager.getTransaction().commit();
        return client;
    }

    public ArrayList<Client> getAllClients(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hannastabledb_pu");
        EntityManager manager = factory.createEntityManager();
        TypedQuery query = manager.createQuery("SELECT C FROM Client C", Client.class);
        ArrayList<Client> list = (ArrayList<Client>) query.getResultList();
        return list;
    }

    public Client getOneClient(int id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hannastabledb_pu");
        EntityManager manager = factory.createEntityManager();
        TypedQuery query = manager.createQuery("SELECT C FROM Client C WHERE C.id = :idOfTheClient", Client.class);
        query.setParameter("idOfTheClient", id);
        Client client = (Client) query.getSingleResult();
        return client;
    }
}
