package com.hannastable.services;

import com.hannastable.daos.ClientsDao;
import com.hannastable.models.Client;

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
}
