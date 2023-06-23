package com.hannastable.daos;

import com.hannastable.models.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ClientsDao {

    public Client createClient(Client client){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hannastabledb_pu");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(client);
        manager.getTransaction().commit();
        return client;
    }
}
