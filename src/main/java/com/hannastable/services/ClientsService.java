package com.hannastable.services;

import com.hannastable.daos.ClientsDao;
import com.hannastable.dtos.ClientDTO;
import com.hannastable.dtos.OrderDTO;
import com.hannastable.models.Client;
import com.hannastable.models.Order;

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

    public ArrayList<ClientDTO> getAllClients() {
        ClientsDao clientsDao = new ClientsDao();
        ArrayList<Client> returnedClient = clientsDao.getAllClients();
        ArrayList<ClientDTO> clientsDTO = new ArrayList<>();

        for (int i = 0; i < returnedClient.size(); i++){
            Client client = returnedClient.get(i);
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setId(client.getId());
            clientDTO.setName(client.getName());

            for (int j =  0; j < client.getOrders().size(); j++){
               Order order = client.getOrders().get(j);

               OrderDTO orderDTO = new OrderDTO();
               orderDTO.setId(order.getId());
                orderDTO.setPrice(order.getPrice());

                clientDTO.getOrders().add(orderDTO);
           }
            clientsDTO.add(clientDTO);
        }
        return clientsDTO;
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

