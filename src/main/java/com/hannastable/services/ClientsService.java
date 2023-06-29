package com.hannastable.services;

import com.hannastable.daos.ClientsDao;
import com.hannastable.models.Client;

import java.util.ArrayList;

public class ClientsService {

    public Client createClient(Client client) throws Exception{
        if (client.getName().length() <= 10 && client.getName().isBlank() == false) {
            ClientsDao clientsDao = new ClientsDao();
            Client returnedClient = clientsDao.createClient(client);
            return returnedClient;
        } else {
            throw new Exception("Invalid Name");
        }
    }

    public ArrayList<Client> getAllClients() {
        ClientsDao clientsDao = new ClientsDao();
        ArrayList<Client> returnedClient = clientsDao.getAllClients();
        return returnedClient;
    }

    public Client getOneClient(int id) {
        ClientsDao clientsDao = new ClientsDao();
        Client returnedClient = clientsDao.getOneClient(id);
        return returnedClient;
    }

    public Client deleteClient(int id){
        ClientsDao clientsDao = new ClientsDao();
        Client returnedClient = clientsDao.deleteClient(id);
        return returnedClient;
    }

    public Client updateClient(int id, Client updatedInfo){
        ClientsDao clientsDao = new ClientsDao();
        Client returnedClient = clientsDao.updateClient(id, updatedInfo);
        return returnedClient;
    }
}

